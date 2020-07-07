package uha.anis.fr.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uha.anis.fr.dao.product.ProductDAO;
import uha.anis.fr.dao.product.ProductDAOImpl;
import uha.anis.fr.entities.Product;
import uha.anis.fr.entities.ProductCart;
import uha.anis.fr.helper.FactoryProvider;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id_prod=request.getParameter("id_prod");
		ProductDAO productDAO=new ProductDAOImpl();
		
		Product product=productDAO.getProductById(Integer.parseInt(id_prod));
		List<ProductCart> myCart=(List<ProductCart>) session.getAttribute("my-cart");
		if(myCart!=null)
		{
			ProductCart pc=new ProductCart(product,"",1);
			if(pc.existInCart(myCart, product))
			{
				pc.setProduct(product);
				int quantity=pc.getProductFromList(myCart, product).getQuantity();			
			    pc.setQuantity(quantity+1);
				int index=pc.getIndexProduct(myCart, product);
				myCart.set(index, pc);
			}else
			{
				ProductCart p=new ProductCart(product, "", 1);
				myCart.add(p);
			}
			
			session.setAttribute("my-cart", myCart);
		}else
		{
			FactoryProvider.productCartList.add(new ProductCart(product, "", 1));
			session.setAttribute("my-cart", FactoryProvider.productCartList);
			
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
