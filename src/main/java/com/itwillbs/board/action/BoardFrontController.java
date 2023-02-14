package com.itwillbs.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController doPost()");
		doProcess(request, response);
	}
	
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController doProcess()");
		System.out.println("뽑은 가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		if(sPath.equals("/BoardWriteForm.bo")) {
			System.out.println("가상주소 /InsertForm.me => 실제페이지 member/insertForm.jsp 이동");

			forward=new ActionForward();
			forward.setPath("board/writeFom.jsp");
			forward.setRedirect(false);
			
			
		}else if(sPath.equals("/BoardWritePro.bo")) {
			action = new BoardWritePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/BoardList.bo")) {
			action = new BoardList();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/FileBoardWriteForm.bo")) {
			forward=new ActionForward();
			forward.setPath("board/fwriteForm.jsp");
			forward.setRedirect(false);
			
			
		}else if(sPath.equals("/FileBoardWritePro.bo")) {
			action = new FileBoardWritePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(sPath.equals("/BoardContent.bo")) {
			action = new BoardContent();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/BoardUpdateForm.bo")) {
			action = new BoardUpdateForm();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/BoardUpdatePro.bo")) {
			action = new BoardUpdatePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/BoardDeletePro.bo")) {
			action = new BoardDeletePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/FileBoardUpdateForm.bo")) {
			action = new FileBoardUpdateForm();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/FileBoardUpdatePro.bo")) {
			action = new FileBoardUpdatePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		if(forward != null) {
			//이동방식비교
			if(forward.isRedirect()==true) {
				// excute함수가 실행되며 forward에 저장된 다른 페이지 주소로 이동함
				response.sendRedirect(forward.getPath());
			}else {
				// 주소가 유지되며 request 값과 가상주소를 Object class형으로 들고감
				RequestDispatcher dispatcher=
				request.getRequestDispatcher(forward.getPath());
		        dispatcher.forward(request, response);
			}
		}
		
	}
	
}//class
