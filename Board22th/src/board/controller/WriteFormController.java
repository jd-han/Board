package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;

public class WriteFormController implements Controller {
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return new ModelAndView("writeForm.jsp");
	}
}