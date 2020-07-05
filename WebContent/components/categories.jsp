<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>

<%
CategoryDAO categoryDao=new CategoryDAOImpl();
List<Category> categories=categoryDao.getCategories();

%>

<div class="well well-small">
	<ul class="nav nav-list">
	  <%
	  for(Category c:categories)
	  {
	  %>
		<li><a href="<%= request.getContextPath()+"/category/categories.jsp?id_cat="+c.getCategoryId()  %>"><span class="icon-chevron-right"></span><%= c.getCategoryTitle() %></a></li>
		<%
	  }
		%>
		
		
		
		<li style="border:0"> &nbsp;</li>
		
	</ul>
</div>



  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="<%= request.getContextPath()+"/assets/img/paypal.jpg" %>" alt="payment method paypal"></a></div>
			