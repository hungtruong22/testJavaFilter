package thuchanhfilter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thuchanhfilter.bean.UserBean;
import thuchanhfilter.bo.UserBo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBo tkbo = new UserBo();
		String tendn = request.getParameter("user");
		String matkhau = request.getParameter("pass");

		RequestDispatcher rd;
		  if(tendn!=null&&matkhau!=null){	
			  UserBean tk= tkbo.login(tendn, matkhau);
			  System.out.println("UB: " + tk);
		  if(tk!=null){
			  //Tao ra doi tuong session
			  HttpSession session=request.getSession();
			  session.setAttribute("dn", tk);
			  response.sendRedirect("check");
			}else { //Dang nhap sai
				request.setAttribute("thongbaoloi", "Sai tên đăng nhập hoặc mật khẩu!");
				rd= request.getRequestDispatcher("login.jsp?kt=1");
				rd.forward(request, response);
			}
		  } else{//Chay lan dau
			  rd= request.getRequestDispatcher("login.jsp");
		  rd.forward(request, response);
		  }
//		
//		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
