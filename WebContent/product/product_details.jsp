<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>All Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="../assets/css/style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet">
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
  </head>
<body>

<%@include file="components/header.jsp" %>
<!--
Navigation Bar Section 
-->
<%@include file="../components/navBar.jsp" %>
<!-- 
Body Section 
-->
	<div class="row">
<div id="sidebar" class="span3">
  <%@ include file="../components/categories.jsp" %>

			
			<br>
			<br>
			

	</div>
	<div class="span9">

	<%@ include file="components/product_informations.jsp" %>

	</div>
	</div>
<!-- 
Clients 
-->

<!--
Footer
-->
<%@ include file="../components/footer.jsp" %>
  </body>
</html>