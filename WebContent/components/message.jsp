
<%
String messsage=(String)session.getAttribute("message");

if(messsage!=null)
{
  out.println(messsage);
  session.removeAttribute("message");
}



%>