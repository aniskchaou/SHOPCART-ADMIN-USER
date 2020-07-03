<%@page import="com.sun.xml.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../is_admin.jsp" %>
<html lang="en">

<head>
 <%@ include file="header.jsp" %>
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
   <%@include file="../navigation.jsp" %>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
     <%@include file="../menu.jsp" %>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          
          <div class="row">
         <%@include file="../hello_message.jsp" %>
          </div>
         
          <div class="row">
           <a href="add_product.jsp">Add product</a>
          </div>
         
          <div class="row">
         <%@include file="products_table.jsp" %>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
       <%@include file="../footer.jsp" %>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
<%@ include file="scripts.jsp" %>
</body>

</html>

