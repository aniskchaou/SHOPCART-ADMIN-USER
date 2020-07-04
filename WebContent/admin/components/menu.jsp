  <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath() %>/admin/admin.jsp">
              <i class="mdi mdi-chart-pie menu-icon"></i>
              <span class="menu-title">Analytics</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link"  href="<%=request.getContextPath() %>/admin/product/products.jsp">
              <i class="mdi mdi-circle-outline menu-icon"></i>
              <span class="menu-title">Products</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath() %>/admin/category/categories.jsp">
              <i class="mdi mdi-view-headline menu-icon"></i>
              <span class="menu-title">Categories</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath() %>/admin/user/users.jsp">
              <i class="mdi mdi-account menu-icon"></i>
              <span class="menu-title">Users</span>
            </a>
          </li>
        
        </ul>
      </nav>