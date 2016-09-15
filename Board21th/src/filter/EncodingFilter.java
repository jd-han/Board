package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String charset;
	@Override
	public void init(FilterConfig config) throws ServletException {
		/*
		<init-param>
          <param-name>charset</param-name>
          <param-value>utf-8</param-value>
        </init-param>
		 */
		charset = config.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			             FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
	
}
