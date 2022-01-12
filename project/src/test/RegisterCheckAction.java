package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCheckAction implements Action {
	MemberDao mDao = new MemberDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		if(mDao.registerCheck(new MemberDto(id, pw, name, point))) {
			request.getRequestDispatcher("register_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
