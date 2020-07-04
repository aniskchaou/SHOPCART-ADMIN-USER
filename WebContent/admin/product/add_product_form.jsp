
<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<div class="col-md-12 stretch-card">
	<div class="card">
		<div class="card-body">
			<p class="card-title">Create new product</p>
			<div class="table-responsive">
				<form action="../../ProductServlet" method="post"
					enctype="multipart/form-data">
					<input name="action" type="hidden" value="add"/>
					<div class="form-group">
						<label for="exampleInputEmail1">Name </label> <input
							name="product_name" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product name"> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Description</label> <input
							name="product_description" type="text" class="form-control"
							id="exampleInputPassword1" placeholder="Product description ">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Discount </label> <input
							name="product_discount" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product discount"> 
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price </label> <input
							name="product_price" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product pice"> 
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Quantity </label> <input
							name="product_quantity" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Product quantity"> 
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
					<button type="submit" class="btn btn-primary">Create</button>
				</form>
			</div>
		</div>
	</div>
</div>