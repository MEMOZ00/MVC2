package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		// D:\Workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Model2\upload
		//6. DB에 저장
		return null;
	}
	
}
