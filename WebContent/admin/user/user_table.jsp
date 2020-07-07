            <%@page import="uha.anis.fr.dao.user.UserDAOImpl"%>
<%@page import="uha.anis.fr.dao.user.UserDAO"%>
<%@page import="uha.anis.fr.dao.user.UserDAOImpl"%>

<%@page import="uha.anis.fr.entities.User"%>
<%@page import="java.util.List"%>

<div class="col-md-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <p class="card-title">List of users</p>
                  <div class="table-responsive">
                    <table id="recent-purchases-listing" class="table">
                      <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Type</th>
                            <th>Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                      <% 
                      UserDAO userDAO=new UserDAOImpl();
                      List<User> users=userDAO.getUsers();
                      for(User u:users)
                      {
                      %>
                     

                            <td><%
                           
                            String path=request.getContextPath()+"/admin/components/images/"+u.getUserPic();
                            %>
                            <img  src="<%= path %>" height="30" width="30" /></td>
                            <td><%= u.getUserEmail() %></td>
                            <td><%= u.getUserPhone() %></td>
                            <td><%= u.getUserAdress() %></td>
                            <td><%= u.getUserType() %></td>
                            <td>
                            <%
                            if(u.getUserType().equals("normal"))
                            {
                            %>
                              <a type="button"  href="#"  class="btn btn-danger" ><i class="mdi  mdi-delete menu-icon"></i></a>
                             <%
                             }
                            %>
                            
                            
                            </td>
                        </tr>
                      <%} %>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>