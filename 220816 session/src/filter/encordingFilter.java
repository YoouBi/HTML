package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(filterName = "EncodingFilter", urlPatterns="/*", initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
// 별표: 사용자가 보내는 모든 요청에 대해 처리.
public class encordingFilter implements Filter {
	
	private String encoding;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		chain.doFilter(request, response);
		
		//
	}


}
