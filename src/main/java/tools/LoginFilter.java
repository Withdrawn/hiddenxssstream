package tools;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		  if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {  
	            throw new ServletException("OncePerRequestFilter just supports HTTP requests");  
	        }  
	        HttpServletRequest httpRequest = (HttpServletRequest) request;  
	        HttpServletResponse httpResponse = (HttpServletResponse) response;  
	        HttpSession session = httpRequest.getSession(true); 
	        String path = httpRequest.getContextPath();  
	        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	        String uri=httpRequest.getRequestURI();
	       if(uri.contains("user/login")||uri.contains("css")||uri.contains("js")||uri.contains("images"))
	       {
	        	chain.doFilter(request, response);
	        	return ;
	       }
//	        Cookie[] cs = httpRequest.getCookies();
//	        int flag=0;
	        if(session.getAttribute("check")==null)
	        {
	        	System.out.println("/user/login");
	        	httpResponse.sendRedirect(basePath+"user/login");
	        	return ;
	        }
	        if(session.getAttribute("check").equals("0"))
	        {
	        	System.out.println("没登录 ");
	        	httpResponse.sendRedirect(basePath+"user/login");
	        }else
	        {
	        	
//			        for(int i=0;i<cs.length;i++){
//			                if(cs[i].getName().equals("xss_uname")||cs[i].getName().equals("xss_upass")){
//			                        flag++;
//			                }
//			        }
	        	
	        	//还存在一个登录后换cookie的问题，重要URL 检查
	        }
	        
	        chain.doFilter(request, response);  
	        return;  
	}

	@Override
	public void destroy() {
	
	}
	 public static boolean isAjaxRequest(HttpServletRequest request) {  
	        return request.getRequestURI().startsWith("/api");  
//	        String requestType = request.getHeader("X-Requested-With");  
//	        return requestType != null && requestType.equals("XMLHttpRequest");  
	    }  
}