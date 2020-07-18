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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserDAO userDAO = new UserDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession();

		String userEmail = request.getParameter("user_email");
		String userPassword = request.getParameter("user_password");
		String userPhone = request.getParameter("user_phone");
		// String userPhoto=request.getParameter("user_photo");
		String userAddress = request.getParameter("user_address");
		String userType = request.getParameter("user_type");
		String userPhoto = "";
		if (userType.contentEquals("admin")) {
			userPhoto = "face_admin.png";
		} else {
			userPhoto = "user.png";
		}
		User user = new User(userEmail, userPassword, userPhone, userPhoto, userAddress, userType);
		System.out.println(user.toString());
		userDAO.addUser(user);

		httpSession.setAttribute("current-user", user);
		httpSession.setAttribute("message-type", "success");
		httpSession.setAttribute("message", "Welcome " + user.getUserEmail() + " !");

		if (userType.contentEquals("normal")) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/admin.jsp");
		}

	}

}
