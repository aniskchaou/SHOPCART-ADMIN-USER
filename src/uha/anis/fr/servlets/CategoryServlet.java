package uha.anis.fr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import uha.anis.fr.dao.category.CategoryDAO;
import uha.anis.fr.dao.category.CategoryDAOImpl;
import uha.anis.fr.entities.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        categoryDAO=new CategoryDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategory=Integer.parseInt(request.getParameter("id"));
		Category category=categoryDAO.getCategoryById(idCategory);
		categoryDAO.deteleCategory(category);
		System.out.println(category.toString());
		HttpSession session=request.getSession();
		session.setAttribute("message", "the category "+idCategory+" is deleted !");
		response.sendRedirect(request.getContextPath()+"/admin/category/categories.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("add"))
		{
			String categoryName=(String) request.getParameter("category_name");
			String categoryDescription=(String) request.getParameter("category_description");
			Category category=new Category(categoryName, categoryDescription);
			categoryDAO.addCategory(category);
			HttpSession session=request.getSession();
			session.setAttribute("message", "New categorie is creacted !");
			response.sendRedirect(request.getContextPath()+"/admin/category/categories.jsp");
		}else
		{
			String categoryName=(String) request.getParameter("category_name");
			String categoryDescription=(String) request.getParameter("category_description");
			int categoryId=Integer.parseInt(request.getParameter("category_id"));
			Category category=new Category(categoryId,categoryName,categoryDescription);
			categoryDAO.UpdateCategory(category);
			HttpSession session=request.getSession();
			session.setAttribute("message", "The categorie is updated !");
			response.sendRedirect(request.getContextPath()+"/admin/category/categories.jsp");
		}
		
		
		
		
		
		
		
		
	}

}
