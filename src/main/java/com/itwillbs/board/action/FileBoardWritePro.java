package com.itwillbs.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.board.db.boardDAO;
import com.itwillbs.board.db.boardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileBoardWritePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileBoardWritePro excute()");
		
		//파일 업로드 프로그램 설치
		// http://www.servlets.com/cos/
		
		//MultipartRequest 생성자 
		//1.request 
		
		//2. 웹서버 업로드 폴더 위치 -> 업로드 할 폴더 생성
		String uploadPath = request.getRealPath("/upload"); 
		System.out.println(uploadPath);
		//3. 파일 최대크기 
		int maxSize = 10*1024*1024;
		//4. 한글처리 
		//5. 업로드 이름 동일할 때 파일 이름 변경
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// multi 업로드 정보 => 디비 저장
		request.setCharacterEncoding("utf-8");

		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		int readcount = 0; 
		String file = multi.getFilesystemName("file");
		
		boardDTO dto = new boardDTO();
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setDate(new Timestamp(System.currentTimeMillis()));
		dto.setReadcount(readcount);
		dto.setFile(file);
		
		boardDAO dao = new boardDAO();
		dao.insertBoard(dto);

//		response.sendRedirect("list.jsp");
		ActionForward forward = new ActionForward();
		forward.setPath("BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
		
		//6. DB에 저장
	}
	
}
