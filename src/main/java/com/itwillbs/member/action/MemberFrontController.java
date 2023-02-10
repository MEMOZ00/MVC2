package com.itwillbs.member.action;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	//주소매핑
	// 가상주소 http://localhost:8080/Model2/InsertForm.me
	
	//메서드 호출 => 자동으로 메서드 호출할려면
	//=> 처리담당자(서블릿) 만들기=> 자동으로 doGet() doPost() service() 호출
	
	//메서드 오버라이딩 alt shift s -> v
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doGet()");
		//방식 상관없이 호출
		doProcess(request, response);
	}//doGet()

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doPost()");
		//방식 상관없이 호출
		doProcess(request, response);
	}//doPost()
	

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doProcess()");
		//주소매핑
		// 가상주소 http://localhost:8080/Model2/InsertForm.me
		//   /InsertForm.me  가상주소 뽑아오기
		System.out.println("뽑은 가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		// 이동정보를 저장하는 자바파일 선언
		ActionForward forward=null;
		//부모 인터페이스 틀 선언
		Action action=null;
		
		if(sPath.equals("/MemberInsertForm.me")) {
			System.out.println("가상주소 /InsertForm.me => 실제페이지 member/insertForm.jsp 이동");

			forward=new ActionForward();
			forward.setPath("member/insertForm.jsp");
			forward.setRedirect(false);
			
						
		}else if(sPath.equals("/MemberInsertPro.me")) {
			System.out.println("가상주소 /MemberInsertPro.me => 실제자바파일 연결");
			action=new MemberInsertPro();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}else if(sPath.equals("/MemberLoginForm.me")) {

			forward=new ActionForward();
			forward.setPath("member/loginForm.jsp");
			forward.setRedirect(false);
			
			
		}else if(sPath.equals("/MemberLoginPro.me")) {
			action = new MemberLoginPro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberMain.me")) {
			
			forward=new ActionForward();
			forward.setPath("member/main.jsp");
			forward.setRedirect(false);
			
			
		}else if(sPath.equals("/MemberLogout.me")) {
			action = new MemberLogout();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberInfo.me")) {
			action = new MemberInfo();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberUpdateForm.me")) {
			action = new MemberUpdateForm();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberUpdatePro.me")) {
			action = new MemberUpdatePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberDeleteForm.me")) {
			forward=new ActionForward();
			forward.setPath("member/deleteForm.jsp");
			forward.setRedirect(false);
			
			
		}else if(sPath.equals("/MemberDeletePro.me")) {
			action = new MemberDeletePro();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(sPath.equals("/MemberList.me")) {
			action = new MemberList();
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// 이동 => 이동정보( 주소정보, 이동방식)=> 이동정보 저장하는 자바파일
//		String path ="주소정보";
//		boolean isRedirect = true;
		// 이동정보 자바파일 있는지 확인
		if(forward != null) {
			//이동방식비교
			if(forward.isRedirect()==true) {
				// excute함수가 실행되며 forward에 저장된 다른 페이지 주소로 이동함
				response.sendRedirect(forward.getPath());
			}else {
				// 주소가 유지되며 request 값과 가상주소를 들고감
				RequestDispatcher dispatcher=
				request.getRequestDispatcher(forward.getPath());
		        dispatcher.forward(request, response);
			}
		}
		
	}//doProcess()
	
}//클래스
