<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.entities.Product"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
</ul>
   <%
	ProductDAO productDAO=new ProductDAOImpl();
    List<Product> products=productDAO.getProducts();
	
	%> 
<div class="well well-small">
		<h1>Check Out <small class="pull-right"> <%= products.size() %> Items are in the cart </small></h1>
	<hr class="soften">	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
				  <th>	Ref. </th>
                  <th>Avail.</th>
                  <th>Unit price</th>
                  <th>Qty </th>
                  <th>Total</th>
				</tr>
              </thead>
              <tbody>
             
    <%
    
    for(Product p:products)
	{
    	
    %>         
             
                <tr>
                  <td><img width="100" src="<%= request.getContextPath()+"/assets/products/"+p.getpPhoto() %>" alt=""></td>
                  <td><b><%= p.getpName() %></b></td>
                  <td> - </td>
                  <td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
                  <td>$ <%= p.getpPrice() %></td>
                  <td>
					<input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="number" value="2">
				  <div class="input-append">
					
				</div>
				</td>
                  <td>$ <%= p.getpPrice() %> </td>
                </tr>
	<%
	}
	%>		
			
			
			

				 <tr>
                  <td colspan="6" class="alignR">Total products:	</td>
                  <td class="label label-primary"> $448.42</td>
                </tr>
				</tbody>
            </table><br>
		
		
	
	<a href="<%= request.getContextPath()+"/index.jsp" %>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
	<a href="<%= request.getContextPath()+"/user/login.jsp" %>" class="shopBtn btn-large pull-right">Next <span class="icon-arrow-right"></span></a>

</div>