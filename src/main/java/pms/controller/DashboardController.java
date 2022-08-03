package pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pms.dto.IssuesDashDto;
import pms.dto.IssuesSch;
import pms.dto.NoticeSch;
import pms.service.DashboardService;
import pms.service.GlobalService;
import pms.vo.Member;
import pms.vo.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {
    @Autowired(required = false)
    private DashboardService service;
    @Autowired(required = false)
    private GlobalService gservice;

	// http://localhost:7080/project06/dashboard.do
    @RequestMapping("dashboard.do")
    public String dashboard(IssuesSch isch, NoticeSch nsch,
                            Model d, HttpServletRequest request){
        for(Notice n:service.getNoticeList(1)){
            System.out.println(n.getNtitle());
        }
        for(IssuesDashDto issue:service.getIssueList(1)){
            System.out.println(issue.getItitle());
        }
        HttpSession session = request.getSession();
        session.setAttribute("mem", gservice.getMember("test@test.com"));
        Member curMem = (Member)request.getSession().getAttribute("mem");
        if(curMem == null){
            return "redirect:login.do";
        }
        System.out.println(curMem.getEmail());

        List<IssuesDashDto> issueList = service.getIssueList(1);
        Integer iprogCount[] = {0,0,0,0};
        for(IssuesDashDto issue:issueList){
            if(issue.getIprogress().equals("해결"))
                iprogCount[0]++;
            else if (issue.getIprogress().equals("해결중"))
                iprogCount[1]++;
            else if (issue.getIprogress().equals("해결불가"))
                iprogCount[2]++;
            iprogCount[3]++;
        }


        d.addAttribute("nlist", service.noticePaging(nsch,1));
        d.addAttribute("ilist", service.issuePaging(isch,1));
        d.addAttribute("iprog", iprogCount);
        return "pms/dashboard.jsp";
    }

    @RequestMapping("issueListAjax.do")
    public String issueListAjax(IssuesSch sch,
                                @RequestParam(value = "pid", defaultValue = "0") int pid, Model d){

        d.addAttribute("ilist", service.issuePaging(sch,1));
        return "pageJsonReport";
    }

    @RequestMapping("noticeListAjax.do")
    public String noticeListAjax(NoticeSch sch,
                                 @RequestParam(value = "pid", defaultValue = "0") int pid, Model d){

        d.addAttribute("nlist", service.noticePaging(sch ,1));
        return "pageJsonReport";
    }
}