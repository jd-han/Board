package login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;

public class LoginFormController implements Controller {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		return "loginForm.jsp";
	}
}
















