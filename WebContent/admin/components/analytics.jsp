        <%@page import="uha.anis.fr.dao.category.CategoryDAO"%>
<%@page import="uha.anis.fr.dao.product.ProductDAOImpl"%>
<%@page import="uha.anis.fr.dao.user.UserDAOImpl"%>
<%@page import="uha.anis.fr.dao.product.ProductDAO"%>
<%@page import="uha.anis.fr.dao.category.CategoryDAOImpl"%>
<%@page import="uha.anis.fr.dao.user.UserDAO"%>
<%
          UserDAO userDAO=new UserDAOImpl();
          ProductDAO productDAO=new ProductDAOImpl();
          CategoryDAO categorieDAO= new CategoryDAOImpl();
          
          long users=userDAO.getNumberUsers();
          long products=productDAO.getNumberProducts();
          long categories=categorieDAO.getNumberCategory();
        %> 
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body dashboard-tabs p-0">
               
                  <div class="tab-content py-0 px-0">
                    <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                      <div class="d-flex flex-wrap justify-content-xl-between">
                      
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi  mdi-checkbox-blank-circle mr-3 icon-lg text-danger"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Products</small>
                            <h5 class="mr-2 mb-0"><%= products %></h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi  mdi-menu mr-3 icon-lg text-success"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Categories</small>
                            <h5 class="mr-2 mb-0"><%= categories %></h5>
                          </div>
                        </div>
                        <div class="d-flex border-md-right flex-grow-1 align-items-center justify-content-center p-3 item">
                          <i class="mdi mdi-account-circle mr-3 icon-lg text-warning"></i>
                          <div class="d-flex flex-column justify-content-around">
                            <small class="mb-1 text-muted">Users</small>
                            <h5 class="mr-2 mb-0"><%= users %></h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>