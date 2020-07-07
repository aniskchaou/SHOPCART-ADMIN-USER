<%@page import="uha.anis.fr.entities.ProductCart"%>
<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.entities.Product"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
</ul>
   <%
    
	HttpSession  seesion=request.getSession();
			List<ProductCart> myCart=(List<ProductCart>) session.getAttribute("my-cart");
			int total=0;
			if(myCart!=null)
			{
	%> 
<div class="well well-small">
		<h1>Check Out <small class="pull-right"> <%= myCart.size() %> Items are in the cart </small></h1>
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
                  <th></th>
				</tr>
              </thead>
              <tbody>
             
    <%
    
    for(ProductCart p:myCart)
	{
    	
    %>         
             
                <tr>
                  <td><img width="100" src="<%= request.getContextPath()+"/assets/products/"+p.getProduct().getpPhoto() %>" alt=""></td>
                  <td><b><%= p.getProduct().getpName() %></b></td>
                  <td> - </td>
                  <td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
                  <td>$ <%= p.getProduct().getpPrice() %></td>
                  <td>
					<!--  <input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="number" value="2">-->
					<%= p.getQuantity() %>
				  <div class="input-append">
					
				</div>
				</td>
                  <td>$ <%= p.getProduct().getpPrice()*p.getQuantity() %> </td>
                  <td><button type="button" class="btn btn-danger"><span class="icon-trash">
				</span></button>
                </tr>
			<%
			total=total+(p.getProduct().getpPrice()*p.getQuantity());
			%>
	 <%
	}
    
	}
	%>		
			
			

				 <tr>
                  <td colspan="6" class="alignR">Total products:	</td>
                  <td class="label label-primary"> $<%= total %></td>
                </tr>
				</tbody>
            </table><br>
		
		
	
	<a href="<%= request.getContextPath()+"/index.jsp" %>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
	<a href="<%= request.getContextPath()+"/cart/order.jsp" %>" class="shopBtn btn-large pull-right">Next <span class="icon-arrow-right"></span></a>
 
</div>