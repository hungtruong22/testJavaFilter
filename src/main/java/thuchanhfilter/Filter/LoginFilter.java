package thuchanhfilter.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thuchanhfilter.bean.UserBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest)request; // bắt được servlet Path
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession(false);
		System.out.println("SS: " + session.getAttribute("dn"));
		if(session == null || session.getAttribute("dn") == null) {
	        res.sendRedirect("login.jsp");
	    } else {
	    	UserBean account = (UserBean) session.getAttribute("dn");
	    	System.out.println("Role: " + account.getRole());
	        if(account != null && account.getRole().equals("admin")) { // Check if account is not null before accessing its role
	            req.getRequestDispatcher("admin").forward(request, response);
	        } else if(account != null && account.getRole().equals("user")){
	            req.getRequestDispatcher("user").forward(request, response);
	        }
	        else {
	        	req.getRequestDispatcher("sing.jsp").forward(request, response);
	        	
	        }
	    }
		
		// pass the request along the filter chain
	    		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
