package login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import framework.Controller;
import framework.ModelAndView;

public class LogoutController implements Controller {

	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView(
				"redirect:" + request.getContextPath() + "/index.jsp");
	}
}

























