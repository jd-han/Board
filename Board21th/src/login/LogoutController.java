package login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import framework.Controller;

public class LogoutController implements Controller {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:" + request.getContextPath() + "/index.jsp";
	}
}

























