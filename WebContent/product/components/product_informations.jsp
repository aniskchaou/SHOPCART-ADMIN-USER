<%@page import="uha.anis.fr.entities.Product"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<ul class="breadcrumb">
    <li><a href="index.html">Home</a> <span class="divider">/</span></li>
    <li><a href="products.html">Items</a> <span class="divider">/</span></li>
    <li class="active">Preview</li>
</ul>
<%
String id_prod=request.getParameter("id_prod");
ProductDAO productDAO=new ProductDAOImpl();
Product product=productDAO.getProductById(Integer.parseInt(id_prod));
%>
<div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                  
                     <img src="<%= request.getContextPath()+"/assets/products/"+product.getpPhoto() %>" alt="" style="width:100%"></a>
                  
                
                </div>
              
            </div>
			</div>
			<div class="span7">
				<h3><%= product.getpName()%> </h3>
				<hr class="soft">
				
				<!--  
				  <div class="control-group">
					<label class="control-label"><span>Quantity</span></label>
					<div class="controls">
					<input type="number" class="span6" placeholder="Qty.">
					</div>
				  </div>
				
				  <div class="control-group">
					<label class="control-label"><span>Color</span></label>
					<div class="controls">
					  <select class="span11">
						  <option>Red</option>
						  <option>Purple</option>
						  <option>Pink</option>
						  <option>Red</option>
						</select>
					</div>
				  </div>
				  <div class="control-group">
					<label class="control-label"><span>Materials</span></label>
					<div class="controls">
					  <select class="span11">
						  <option>Material 1</option>
						  <option>Material 2</option>
						  <option>Material 3</option>
						  <option>Material 4</option>
						</select>
					</div>
				  </div>
				  -->
				  <h2 ><%= product.getpPrice() %> $</h2>
				  <h4>Discount : <%= product.getpDiscount() %> %</h4>
				  <h4><%= product.getpQuantity() %> items in stock</h4>
				  <p><%= product.getpDescription() %>
				  </p><p>
				  <a href="<%= request.getContextPath()+"/Cart?id_prod="+product.getpId() %>" type="button" class="shopBtn"><span class=" icon-shopping-cart"></span> Add to cart</a>
				</p>
			</div>
			</div>
				<hr class="softn clr">

</div>