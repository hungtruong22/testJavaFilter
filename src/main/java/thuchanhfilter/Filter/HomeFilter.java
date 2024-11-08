//package thuchanhfilter.Filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class HomeFilter
// */
//@WebFilter("/*")
//public class HomeFilter implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//	
//	private FilterConfig filterConfig = null;
//	private int counter;
//	
//    public HomeFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//
//		// pass the request along the filter chain
//		
//		HttpServletRequest req = (HttpServletRequest)request; // bắt được servlet Path
//		HttpServletResponse res = (HttpServletResponse)response;
//		
//		HttpSession session = req.getSession();
//		
//		counter++;
//		
//		session.setAttribute("counter", counter);
//		
//		String uri = req.getServletPath();
//		if(uri.endsWith(".jsp") && !uri.contains("log.jsp")) {
//			// đưa về home
//			res.sendRedirect("home");
//		}else if(uri.contains("log.jsp")) {
//			req.getRequestDispatcher("log.jsp").forward(request, response);
//		}
//		
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		counter = 0;
//	}
//
//}
