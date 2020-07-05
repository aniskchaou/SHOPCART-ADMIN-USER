    <ul class="breadcrumb">
		<li><a href="#">Home</a> <span class="divider">/</span></li>
		<li class="active">Registration</li>
    </ul>
	<hr class="soft">
	<div class="well">
	<form class="form-horizontal" action="../RegisterServlet" method="post">
		
		
		
		<div class="control-group">
		<label class="control-label" for="inputEmail">Username <sup>*</sup></label>
		<div class="controls">
		  <input type="text" placeholder="Username" name="user_email">
		</div>
	  </div>	  
		<div class="control-group">
		<label class="control-label">Password <sup>*</sup></label>
		<div class="controls">
		  <input type="password" placeholder="Password" name="user_password">
		</div>
	  </div>
	   <div class="control-group">
			<label class="control-label" for="inputLname">Phone <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputLname" placeholder="Phone" name="user_phone">
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="inputFname">Address <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputFname" placeholder="Address" name="user_address">
			</div>
		 </div>
		<!-- <div class="control-group">
			<label class="control-label" for="inputFname">Photo <sup>*</sup></label>
			<div class="controls">
			  <input type="hidden" id="inputFname" placeholder="First Name" name="user_photo">
			</div>
		  </div>
	    -->
	    <div class="control-group">
			<label class="control-label" for="inputFname">Type <sup>*</sup></label>
			<div class="controls">
			  <select type="hidden" id="inputFname" placeholder="First Name" name="user_type">
			    <option value="admin">Admin</option>
			    <option value="normal">Normal</option>
			  </select>
			</div>
		  </div>
	    
	<div class="control-group">
		<div class="controls">
		 <input type="submit" name="submitAccount" value="Register" class="exclusive shopBtn">
		</div>
	</div>
	</form>
</div>


