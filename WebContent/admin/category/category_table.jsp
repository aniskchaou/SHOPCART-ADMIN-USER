            <%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<%@page import="uha.anis.fr.entities.Category"%>
<%@page import="java.util.List"%>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">List of categories</p>
                  <a data-toggle="tooltip" data-placement="top" title="Add category"  href="add_category.jsp" class="btn btn-success" type="button">    <i class="mdi  mdi-plus-circle-outline menu-icon"></i></a>
                  <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                      <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                      <% 
                      CategoryDAO categoryDAO=new CategoryDAOImpl();
                      List<Category> categories=categoryDAO.getCategories();
                      for(Category c:categories)
                      {
                      %>
                     

                            <td><%=c.getCategoryId() %></td>
                            <td><%= c.getCategoryTitle() %></td>
                            <td><%= c.getCategoryDescription() %></td>
                            <td>
                            
                              <a type="button" href="edit_category.jsp?id=<%= c.getCategoryId()   %>" class="btn btn-warning" ><i class="mdi  mdi-tooltip-edit menu-icon"></i></a>
                             <a type="button"  href="<%=request.getContextPath()+"/CategoryServlet?id="+ c.getCategoryId() %>" class="btn btn-danger" ><i class="mdi  mdi-delete menu-icon"></i></a>
                             
                             
                             
                 
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                            </td>
                        </tr>
                      <%} %>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>