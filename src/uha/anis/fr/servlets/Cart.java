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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id_prod = request.getParameter("id_prod");
		ProductDAO productDAO = new ProductDAOImpl();
		String action = request.getParameter("action");
		Product product = null;
		if (id_prod != null) {
			product = productDAO.getProductById(Integer.parseInt(id_prod));
		}
		List<ProductCart> myCart = (List<ProductCart>) session.getAttribute("my-cart");
		if (action == null) {

			if (myCart != null) {
				ProductCart pc = new ProductCart(product, "", 1);
				if (ProductCart.existInCart(myCart, product)) {
					pc.setProduct(product);
					int quantity = ProductCart.getProductFromList(myCart, product).getQuantity();
					pc.setQuantity(quantity + 1);
					int index = ProductCart.getIndexProduct(myCart, product);
					myCart.set(index, pc);
				} else {
					ProductCart p = new ProductCart(product, "", 1);
					myCart.add(p);
				}

				session.setAttribute("my-cart", myCart);

			} else {
				FactoryProvider.productCartList.add(new ProductCart(product, "", 1));
				session.setAttribute("my-cart", FactoryProvider.productCartList);

			}
			session.setAttribute("message", product.getpName() + " was added to your cart.");
			session.setAttribute("message-type", "success");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if (action.equals("remove")) {
			ProductCart.removeFromList(myCart, product);
			session.setAttribute("message", product.getpName() + " was removed from your cart.");
			session.setAttribute("message-type", "success");
			response.sendRedirect(request.getContextPath() + "/cart/my_cart.jsp");
		} else if (action.equals("clear")) {
			ProductCart.removeAll(myCart);
			session.setAttribute("message", "your cart is empty.");
			session.setAttribute("message-type", "success");
			response.sendRedirect(request.getContextPath() + "/cart/my_cart.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
