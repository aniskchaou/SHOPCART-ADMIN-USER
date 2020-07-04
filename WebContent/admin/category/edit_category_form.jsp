<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<%
String categoryId=request.getParameter("id");
CategoryDAO  categoryDAO=new CategoryDAOImpl();
Category   category=categoryDAO.getCategoryById(Integer.parseInt(categoryId));
%>

<div class="col-md-12 stretch-card">
	<div class="card">
		<div class="card-body">
			<p class="card-title">Edit Category</p>
			<div class="table-responsive">
				<form action="../../CategoryServlet" method="post">
				<input name="action" type="hidden" value="edit"/>
				 <input type="hidden" name="category_id" value="<%= category.getCategoryId() %>"> 
					<div class="form-group">
						<label for="exampleInputEmail1">Category Name</label> <input
							name="category_name" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Category Name" value="<%= category.getCategoryTitle() %>" > 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Category Description</label> <textarea
							name="category_description"  class="form-control"
							id="exampleInputPassword1" placeholder="Category description" ><%= category.getCategoryDescription() %></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Edit</button>
				</form>
			</div>
		</div>
	</div>
</div>