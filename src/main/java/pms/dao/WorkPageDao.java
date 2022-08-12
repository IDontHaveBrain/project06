package pms.dao;

import java.util.List;

// pms.dao.WorkPageDao
import org.springframework.stereotype.Repository;

import pms.vo.WorkPage;
import pms.vo.WorkPageFile;

@Repository
public interface WorkPageDao {
	// 리스트
	public List<WorkPage> WorkPageList(int mid,int pid);
	public List<WorkPage> getWorkPageList(WorkPage sch);
	
	// 파일등록
	public void insertFile(WorkPageFile file);
	
	// 상세화면
	public List<WorkPage> WorkPageDetailList(int mid,int jid);
	public List<WorkPage> getWorkPageDetailList(WorkPage sch);
	
	// 상세화면 파일 다운로드
	public List<WorkPage> getWorkPageFile(WorkPage filelist);
	
	// 승인요청 보내기
	public void updateWorkPage(int jmid);	
	
	// 파일 삭제하기
	public void deleteWorkPageFile(int fid);	
	
}




