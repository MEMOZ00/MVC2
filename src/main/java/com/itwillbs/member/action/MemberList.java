package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao=new MemberDAO();
		ArrayList<MemberDTO> memberList =dao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		ActionForward forward =new ActionForward();
		forward.setPath("member/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
