	<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.entities.Product"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<%
    String id_cat=request.getParameter("id_cat");
    CategoryDAO  categoryDAO=new CategoryDAOImpl();
    Category  category=categoryDAO.getCategoryById(Integer.parseInt(id_cat));
	ProductDAO productDAO=new ProductDAOImpl();
    List<Product> products=productDAO.getProductsByCategory(Integer.parseInt(id_cat));
	
	%>
	 <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Category</li>
    </ul>
	<hr class="soft">
	<div class="well well-small">
	<h3><%= category.getCategoryTitle() %>  </h3>
	<hr class="soften"/>
		<div class="row-fluid">
		  <ul class="thumbnails">
			<%
			for(Product p:products)
			{	
			
			%>
			<li class="span4">
			  <div class="thumbnail"> 
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="<%= request.getContextPath()+"/assets/products/"+p.getpPhoto() %>" alt=""></a>
				<div class="caption cntr">
					<p><%= p.getpName()%></p>
					<p><strong> $<%= p.getpPrice() %></strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
					
					<br class="clr">
				</div>
			  </div>
			</li>
			<%
			}
			%>
		
		  </ul>
		</div>
	</div>