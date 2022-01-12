package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao mDao = new MemberDao();
		
		String command = request.getParameter("command");

		if(command.equals("admin_check")) {
			ArrayList<MemberDto> memberList = mDao.memberList();
			
			if(memberList != null) {
				request.setAttribute("memberList", memberList);
				request.getRequestDispatcher("admin_main.jsp").forward(request, response);
			}
 		}
	}

}
