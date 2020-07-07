<%@page import="uha.anis.fr.entities.User"%>
<ul class="breadcrumb">
		<li><a href="#">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
</ul>
<%
User user1=(User)session.getAttribute("current-user");
if(user1!=null)
{
%>
	<hr class="soft">
	<div class="well">
	<form class="form-horizontal" action="<%=request.getContextPath()+"/OrderServlet" %>" method="post">
		
		
		
		<div class="control-group">
		<label class="control-label" for="inputEmail">Username <sup>*</sup></label>
		<div class="controls">
		  <input type="text" placeholder="Username" name="user_email" value="<%= user1.getUserEmail() %>">
		</div>
	  </div>	  
		
	   <div class="control-group">
			<label class="control-label" for="inputLname">Phone <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputLname" placeholder="Phone" name="user_phone" value="<%= user1.getUserPhone()%>">
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="inputFname">Address <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputFname" placeholder="Address" name="user_address" value="<%= user1.getUserAdress() %>">
			</div>
		 </div>
		<!-- <div class="control-group">
			<label class="control-label" for="inputFname">Photo <sup>*</sup></label>
			<div class="controls">
			  <input type="hidden" id="inputFname" placeholder="First Name" name="user_photo">
			</div>
		  </div>
	    -->
<%
}else
{
	response.sendRedirect(request.getContextPath()+"/user/login.jsp");
}%>   
	    
	<div class="control-group">
		<div class="controls">
		 <input type="submit" name="submitAccount" value="Order now" class="exclusive shopBtn">
		</div>
	</div>
	</form>
</div>


