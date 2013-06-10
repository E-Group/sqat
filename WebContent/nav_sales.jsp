
	<!-- NAVIGATION BAR -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Commission</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as ${loginbean.username}
            </p>
            <ul class="nav">
              <li class="active"><a href="add_sale.jsp">Add sale</a></li>
              <li><a href="<%=request.getContextPath()%>/SalesServlet">Sales</a></li>
              <li><a href="<%=request.getContextPath()%>/SalesServlet">Salary</a></li>
              <li><a href="about.jsp">About</a></li>
              <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
