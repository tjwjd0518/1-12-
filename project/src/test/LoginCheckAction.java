package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckAction implements Action {
	MemberDao mDao = new MemberDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(mDao.loginCheck(new MemberDto(id, pw, "", ""))) {
			request.setAttribute("loginId", id);
			if(id.equals("admin")) {
				request.getRequestDispatcher("Controller?command=admin_main").forward(request, response);
			} else {
				request.getRequestDispatcher("login.jap").forward(request, response);
			}
			request.getRequestDispatcher("login_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login_fail.jsp").forward(request, response);
		}
	}
}
