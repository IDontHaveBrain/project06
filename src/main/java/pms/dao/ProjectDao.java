package pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pms.dto.ProjectDto;
import pms.dto.ProjectMemberDTO;
import pms.vo.Member;
import pms.vo.Participants;
import pms.vo.Project;



@Repository
public interface ProjectDao {
	public List<Project> getProjectList();
	public List<Member> getMemberList();
	public List<ProjectMemberDTO> getPmemberList(int pid); //조회
	
	public Project getProjectDetail(int pid);
	
	public void insertProject(ProjectDto ins);	
	public void insertParticipants(Participants p);
	
	public void updateProject(ProjectDto upt);

	
	
	
	public void deleteProject(int pid);
	public void deleteMember(int pid);
}
