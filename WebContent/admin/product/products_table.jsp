            <%@page import="uha.anis.fr.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">List of products</p>
                  <a href="add_product.jsp" class="btn btn-success" type="button"> <i class="mdi  mdi-plus-circle-outline menu-icon"></i></a>
                  <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                      <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Discount</th>
                            <th>Price </th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                      <% 
                      ProductDAO productDAO=new ProductDAOImpl();
                      List<Product> products=productDAO.getProducts();
                      for(Product p:products)
                      {
                      %>
                     
                        <tr>
                            <td><img  src="<%="../../assets/products/"+p.getpPhoto() %>" height="35" width="35" /></td>
                            <td><%= p.getpName() %></td>
                            <td><%= p.getpDiscount() %></td>
                            <td><%= p.getpPrice() %></td>
                            <td><%= p.getpQuantity() %></td>
                            <td><%= p.getCategory().getCategoryTitle() %></td>
                            <td> <a  href="edit_product.jsp?id=<%= p.getpId() %>" type="button" class="btn btn-warning" class="btn btn-warning"><i class="mdi  mdi-tooltip-edit menu-icon"></i></a>
                             <a type="button"  href="<%=request.getContextPath()+"/ProductServlet?id="+ p.getpId() %>" class="btn btn-danger" ><i class="mdi  mdi-delete menu-icon"></i></a>
                             </td>
                        </tr>
                      <%} %>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>