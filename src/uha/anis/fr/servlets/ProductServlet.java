package uha.anis.fr.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import uha.anis.fr.dao.category.CategoryDAO;
import uha.anis.fr.dao.category.CategoryDAOImpl;
import uha.anis.fr.dao.product.ProductDAO;
import uha.anis.fr.dao.product.ProductDAOImpl;
import uha.anis.fr.entities.Category;
import uha.anis.fr.entities.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		productDAO = new ProductDAOImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idProduct = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.getProductById(idProduct);
		productDAO.deleteProduct(product);
		;
		// System.out.println(category.toString());
		HttpSession session = request.getSession();
		session.setAttribute("message", "the product " + idProduct + " is deleted !");
		response.sendRedirect(request.getContextPath() + "/admin/product/products.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("add")) {
			String productName = request.getParameter("product_name");
			String productDescription = request.getParameter("product_description");
			int productDiscount = Integer.parseInt(request.getParameter("product_discount"));
			// String productPhoto=request.getParameter("product_photo");

			int productPrice = Integer.parseInt(request.getParameter("product_price"));
			int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			int productCategory = Integer.parseInt(request.getParameter("product_category"));

			Part filePart = request.getPart("product_photo"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			// InputStream fileContent = filePart.getInputStream();

			// gets absolute path of the web application
			String appPath = request.getServletContext().getRealPath("assets");
			// constructs path of the directory to save uploaded file
			new File(appPath + File.separator + "products" + File.separator).mkdirs();
			String savePath = appPath + File.separator + "products" + File.separator + fileName;
			System.out.println(savePath);
			FileOutputStream fos = new FileOutputStream(savePath);
			InputStream is = filePart.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

			CategoryDAO categoryDAO = new CategoryDAOImpl();
			Category category = categoryDAO.getCategoryById(productCategory);

			Product product = new Product(productName, productDescription, fileName, productPrice, productDiscount,
					productQuantity, category);
			ProductDAO productDAO = new ProductDAOImpl();
			productDAO.addProduct(product);
			HttpSession session = request.getSession();
			session.setAttribute("message", "New product is creacted !");
			response.sendRedirect(request.getContextPath() + "/admin/product/products.jsp");
		} else {
			Part filePart = request.getPart("product_photo");
			String productName = request.getParameter("product_name");
			String productDescription = request.getParameter("product_description");
			int productDiscount = Integer.parseInt(request.getParameter("product_discount"));
			String productPhoto = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			int productId = Integer.parseInt(request.getParameter("product_id"));
			int productPrice = Integer.parseInt(request.getParameter("product_price"));
			int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			int productCategory = Integer.parseInt(request.getParameter("product_category"));

			// Part filePart = request.getPart("product_photo");
			CategoryDAO categoryDAO = new CategoryDAOImpl();
			Category category = categoryDAO.getCategoryById(productCategory);

			Product product = new Product(productId, productName, productDescription, productPhoto, productPrice,
					productDiscount, productQuantity, category);
			System.out.println(product.toString());
			ProductDAO productDAO = new ProductDAOImpl();
			productDAO.updateProduct(product);
			HttpSession session = request.getSession();
			session.setAttribute("message", "New product is updated !");
			response.sendRedirect(request.getContextPath() + "/admin/product/products.jsp");
			this.uploadFile(request);
		}

	}

	private void uploadFile(HttpServletRequest request) throws IOException, ServletException {
		Part filePart = request.getPart("product_photo"); // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		// InputStream fileContent = filePart.getInputStream();

		// gets absolute path of the web application
		String appPath = request.getServletContext().getRealPath("assets");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + "products" + File.separator + fileName;
		System.out.println(savePath);
		FileOutputStream fos = new FileOutputStream(savePath);
		InputStream is = filePart.getInputStream();
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
	}

}
