<%@ page import="uha.anis.fr.entities.*" %>
<% 
   User user=(User)session.getAttribute("current-user");
if(user==null)
{
	response.sendRedirect("user/login.jsp");
}else
{
	if(user.getUserType().equals("normal"))
	{
		response.sendRedirect("user/login.jsp");
	}
}

%>