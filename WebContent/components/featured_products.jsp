<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.entities.Product"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<%
	ProductDAO productDAO1=new ProductDAOImpl();
    List<Product> products1=productDAO1.getProducts();
	
	%>
		<div class="well well-small">
		  <h3><a class="btn btn-mini pull-right" href="product/products.jsp" title="View more">VIew More<span class="icon-plus"></span></a> Featured Products  </h3>
		  <hr class="soften"/>
		  <div class="row-fluid">
		  <ul class="thumbnails">
		<%
			for(Product p:products1)
			{	
			
			%>
			<li class="span4">
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a  href="product_details.html"><img src="<%= request.getContextPath()+"/assets/products/"+p.getpPhoto() %>" alt=""></a>
				<div class="caption">
				  <h5><%= p.getpName()%></h5>
				  <h4>
					  <a class="defaultBtn" href="product_details.html" title="Click to view"><span class="icon-zoom-in"></span></a>
					  <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
					  <span class="pull-right">$<%= p.getpPrice() %></span>
				  </h4>
				</div>
			  </div>
			</li>
		  <%
			}
		  %>
		  </ul>	
	</div>
	</div>