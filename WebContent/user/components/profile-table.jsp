  <%@page import="uha.anis.fr.entities.User"%>
<ul class="breadcrumb">
		<li><a href="#">Home</a> <span class="divider">/</span></li>
		<li class="active">My profile</li>
    </ul>

	<hr class="soft">
		
			<div class="well">
			<%
			HttpSession  seesion=request.getSession();
			User u=(User) session.getAttribute("current-user");
			%>
			<br/>
			<p><img src="<%= request.getContextPath()+"/admin/components/images/user.png" %>" height="100" width="100"/></p>
			<p>Username : <%= u.getUserEmail() %> </p>
			<p>Phone : <%= u.getUserPhone()%></p>
			<p>Address : <%= u.getUserAdress()%> </p>
		</div>
