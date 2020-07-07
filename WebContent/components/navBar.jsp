
<%@page import="uha.anis.fr.dao.user.UserDAOImpl"%>
<%@page import="uha.anis.fr.entities.User"%>
<%@page import="uha.anis.fr.dao.user.UserDAO"%>
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
			  <li ><a href="<%= request.getContextPath()+"/index.jsp" %>">Home	</a></li>
			  <li class=""><a href="<%= request.getContextPath()+"/user/register.jsp" %>">Register</a></li>
			  <li class=""><a href="<%= request.getContextPath()+"/product/products.jsp" %>">Products</a></li>
			
			</ul>
			<!--  <form action="#" class="navbar-search pull-left">
			  <input type="text" placeholder="Search" class="search-query span2">
			</form>-->
			<ul class="nav pull-right">
			<%
			//String param=request.getParameter("id");
			 User user=(User)session.getAttribute("current-user");
			  
			if(user==null)
			{
			
			%>
			<li class="dropdown">
				<a  href="<%= request.getContextPath()+"/user/login.jsp" %>">
				<span class="icon-lock">
				</span> Login</a>

			</li>
			<%
			}else{
				//int idUser=Integer.parseInt(param);
				//UserDAO  userDAO=new UserDAOImpl();
				//User  user=userDAO.getUserById(idUser);
				
				 
				  
				
				
				out.print("<li class=\"dropdown\"><a href=\""+request.getContextPath()+"/user/profile.jsp\"><span class=\"icon-user\"></span>  "+user.getUserEmail()+"</a></li>");
				out.print("<li><a href=\""+request.getContextPath()+"/LoginServlet?action=logout\"> <span class=\"icon-signout\"></span> Log Out</a></li>");
			  }
			%>
			</ul>
		  </div>
		</div>
	  </div>
	</div>