package pms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dao.GlobalDao;
import pms.vo.Jobplan;
import pms.vo.Member;

@Service
public class GlobalService {
    @Autowired(required = false)
    private GlobalDao dao;

    public Member getMember(String email) {
        return dao.getMember(email);
    }
    public List<Jobplan> jobplanListPrj(int pid) {
        return dao.jobplanListPrj(pid);
    }
    public boolean isProjectMember(Integer mid, Integer pid) {
        Map<String, Object> map = new HashMap<>();
        map.put("mid", mid);
        map.put("pid", pid);
        return dao.isProjectMember(map);
    }
    public boolean checkProjectAuth(Integer mid, Integer pid) {
        Map<String, Object> map = new HashMap<>();
        map.put("mid", mid);
        map.put("pid", pid);
        return dao.checkProjectAuth(map);
    }
    public boolean isAdmin(int mid){
        return dao.isAdmin(mid);
    }
}
