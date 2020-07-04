
<%
String messsage=(String)session.getAttribute("message");

if(messsage!=null)
{
	%>
	<div class="alert alert-success" role="alert">
  <%  out.println(messsage); %>
</div>
<%	
 
  session.removeAttribute("message");
}



%>