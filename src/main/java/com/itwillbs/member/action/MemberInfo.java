package com.itwillbs.member.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberInfo implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		// dto 정보, 주소 정보를 들고 주소변경없이 MemberInfo.jsp로 이동 
		// dispatcher.forward(request, response); 가 request 정보를 들고가므로 
		// request.setAttribute("dto", dto); 로 request에 dto값이 담기고 forward에 dto 값이 저장됨
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("member/info.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}
