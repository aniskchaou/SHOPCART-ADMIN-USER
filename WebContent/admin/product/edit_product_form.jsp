<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<%@page import="uha.anis.fr.entities.Product"%>
<%
String productId=request.getParameter("id");
ProductDAO  productDAO=new ProductDAOImpl();
Product   product=productDAO.getProductById(Integer.parseInt(productId));

%>


<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<div class="col-md-12 stretch-card">
	<div class="card">
		<div class="card-body">
			<p class="card-title">Edit product</p>
			
			<div class="table-responsive">
				<form action="../../ProductServlet" method="post"
					enctype="multipart/form-data">
					
					<input type="hidden" name="product_id" value="<%= product.getpId()  %>" />
					<div class="form-group">
						<label for="exampleInputEmail1">Name </label> <input
							name="product_name" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product name" value="<%= product.getpName()  %>"> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Description</label> <input
							name="product_description" type="text" class="form-control"
							id="exampleInputPassword1" placeholder="Product description " value="<%= product.getpDescription()  %>">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Discount </label> <input
							name="product_discount" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product discount" value="<%= product.getpDiscount()  %>"> 
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price </label> <input
							name="product_price" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product pice" value="<%= product.getpPrice()  %>"> 
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Quantity </label> <input
							name="product_quantity" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product quantity" value="<%= product.getpQuantity()  %>"> 
					</div>
					<%
						CategoryDAO categoryDAO = new CategoryDAOImpl();
						List<Category> categories = categoryDAO.getCategories();
					%>
					<div class="form-group">
						<label for="exampleInputEmail1">Category </label> <select class="form-control"
							name="product_category">
							<%
								for (Category c : categories) {
							%>
							<option value="<%=c.getCategoryId()%>">
								<%=c.getCategoryTitle()%>
							</option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Photo </label> <input
							name="product_photo" type="file" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter email"> 
					</div>
					<button type="submit" class="btn btn-primary">Edit</button>
				</form>
			</div>
		</div>
	</div>
</div>