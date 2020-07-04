package uha.anis.fr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uha.anis.fr.dao.user.UserDAO;
import uha.anis.fr.dao.user.UserDAOImpl;
import uha.anis.fr.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;
       
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
		String disconnect=request.getParameter("action");
		if(disconnect.equals("logout"))
		{
			HttpSession session=request.getSession();
			session.removeAttribute("current-user");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("useremail");
		String userPassword=request.getParameter("password");
		user = null;
		UserDAO userDAO=new UserDAOImpl();
		 user=userDAO.getUserByEmailPassword(userEmail, userPassword);
		HttpSession httpSession=request.getSession();
		
		if(user==null)
		{
			httpSession.setAttribute("message", "Invalid password or email");
			response.sendRedirect("user/login.jsp");
			
		}else
		{   
			 httpSession.setAttribute("message", "Welcome "+user.getUserEmail());
			
		     httpSession.setAttribute("current-user", user);
		     
		     if(user.getUserType().equals("admin"))
		     {
		    	 response.sendRedirect("admin/admin.jsp");
		     }else if (user.getUserType().equals("normal"))
		     {
		    	 response.sendRedirect("index.jsp"); 
		     }else
		     {
		    	 
		     }
			
		}
	}

}
