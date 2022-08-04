package pms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pms.service.ProjectService;
import pms.vo.Project;


@Controller
public class ProjectController {
	@Autowired(required=false)
	private ProjectService service;
	
	// http://localhost:7080/project06/projectList.do
	@RequestMapping("projectList.do")
	public String projectList(Model d) {
		d.addAttribute("projectList", service.getProjectList());
		return "WEB-INF\\views\\projectlist.jsp";
	}
	
	// http://localhost:7080/project06/projectInsertForm.do
	@RequestMapping("projectInsertForm.do")
	public String projectInsertForm(){
		return "WEB-INF\\views\\project.jsp";
	}
	
	@RequestMapping("projectInsert.do")
	public String projectInsert(Project ins, Model d){
		service.insertProject(ins);
		d.addAttribute("isInsert","Y");
		
		return "WEB-INF\\views\\project.jsp";
	}
	
	@RequestMapping("projectDetail.do")
	public String projectDetail(@RequestParam("pid") int pid, Model d){
		d.addAttribute("project",service.getProjectDetail(pid));
		
		return "WEB-INF\\views\\projectdetail.jsp";
	}
	
	@RequestMapping("deleteProject.do")
	public String deleteProject(@RequestParam("pid") int pid, Model d){	
		service.deleteProject(pid);
		d.addAttribute("proc","del");
		
		return "WEB-INF\\views\\projectlist.jsp";	
	}

	
	/*
	@RequestMapping("updateProject.do")
	public String updateProject(Project upt, Model d){		
		d.addAttribute("project",service.updateProject(upt));
		d.addAttribute("proc","upt");

		return "WEB-INF\\views\\projectedit.jsp";
	}
	
	 */

}

