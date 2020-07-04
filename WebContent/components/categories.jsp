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
		<li><a href="products.html"><span class="icon-chevron-right"></span><%= c.getCategoryTitle() %></a></li>
		<%
	  }
		%>
		
		
		
		<li style="border:0"> &nbsp;</li>
		
	</ul>
</div>