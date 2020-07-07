<!-- 
	Upper Header Section 
-->


<!--
Lower Header Section 
-->
<%@page import="uha.anis.fr.entities.ProductCart"%>
<%@page import="java.util.List"%>
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="<%= request.getContextPath()+"/index.jsp" %>"> 
		<img src="<%= request.getContextPath()+"/assets/img/logo-bootstrap-shoping-cart.png" %>" alt="">
	</a>
	</h1>
	</div>
	<div class="span4">
	
	</div>
	<div class="span4 alignR">
	<%
	//HttpSession  session=request.getSession();
	List<ProductCart> mycart=(List<ProductCart>)session.getAttribute("my-cart");
	int size=0;
	if(mycart!=null)
	{
		size=mycart.size();
	}
	%>
	<span class="btn"><a href="<%= request.getContextPath()+"/cart/my_cart.jsp" %>"><span class="badge badge-warning"><%= size %></span> <span class="icon-shopping-cart"></span></a></span>
	</div>
</div>
</header>