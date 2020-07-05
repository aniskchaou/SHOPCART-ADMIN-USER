  <script src="//ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%
String messsage=(String)session.getAttribute("message");
String type=(String)session.getAttribute("message-type");
if(messsage!=null)
{
	%>
	<div class="alert alert-<%= type %>" id="passwordsNoMatchRegister" style="display:none;">
    <strong> <%  out.println(messsage); %></strong> 
  </div>
 
<%	
 
  session.removeAttribute("message");
}



%>


  
<script>
myFunction();
function myFunction() {
	   $('#passwordsNoMatchRegister').fadeIn(1000);
	   setTimeout(function() { 
	       $('#passwordsNoMatchRegister').fadeOut(1000); 
	   }, 3000);
	}
</script>