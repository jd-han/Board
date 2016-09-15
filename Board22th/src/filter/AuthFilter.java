package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Member;

public class AuthFilter implements Filter {
	private List<String> pageList;
	@Override
	public void init(FilterConfig config) throws ServletException {
		String pages = config.getInitParameter("pages");
		System.out.println("로그인 없이 호출가능한 페이지");
		System.out.println("----------------------------");
//		System.out.println(pages);
		String[] pageArr = pages.split(";");
		// 로그인 없이 사용할 페이지 정보를 리스트에 추가
		pageList = new ArrayList<>();
		for (String p : pageArr)  
			pageList.add(p.trim());
		
		System.out.println(pageList);
		System.out.println("----------------------------");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			             FilterChain chain)
			throws IOException, ServletException {
		// pageList 에 호출한 페이지가 존재할 경우
		// 다음 페이지로 이동시킨다.
		// pageList 에 호출한 페이지가 존재하지 않을 경우
		//   - 세션에 user 정보가 등록되어 있는지 확인한다.
		//     user 정보가 등록되지 않은 경우는 loginForm 페이지로 이동시킴
		//     user 정보가 등록되어 있는 경우 다음 페이지로 이동시킴
		HttpServletRequest hRequest = (HttpServletRequest)request;
		String requestUri = hRequest.getRequestURI();
		String contextPath = hRequest.getContextPath();
		requestUri = requestUri.substring(contextPath.length());
		
		boolean isRedirect = false;
		int index = pageList.indexOf(requestUri);
		if (index == -1) {
			HttpSession session = hRequest.getSession();
			Member user = (Member)session.getAttribute("user");
			if (user == null) {
				isRedirect = true;
			}
		} 
		if (isRedirect) {
			HttpServletResponse hResponse = (HttpServletResponse)response;
			hResponse.sendRedirect(
					hRequest.getContextPath() + "/login/loginForm");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {}
	
}
