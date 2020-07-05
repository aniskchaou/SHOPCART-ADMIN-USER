  <ul class="breadcrumb">
		<li><a href="#">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>

	<hr class="soft">
		<div class="span4">
			<div class="well">
			<br/><br/><br/>
			<form action="../LoginServlet" method="post">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Username</label>
				<div class="controls">
				  <input  name="useremail" class="span3"  type="text" placeholder="Email">
				</div>
			  </div>
			  	<div class="control-group">
				<label class="control-label" for="inputEmail">Password</label>
				<div class="controls">
				  <input class="span3" name="password" type="password" placeholder="Password">
				</div>
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn block">Sign In</button>
			  </div>
			</form>
		</div>
		</div>