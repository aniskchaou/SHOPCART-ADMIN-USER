<%@ page import="uha.anis.fr.entities.*" %>
<% 
   User user=(User)session.getAttribute("current-user");
if(user==null)
{
	response.sendRedirect(request.getContextPath()+"/user/login.jsp");
}else
{
	if(user.getUserType().equals("normal"))
	{
		response.sendRedirect(request.getContextPath()+"/user/login.jsp");
	}
}

%>