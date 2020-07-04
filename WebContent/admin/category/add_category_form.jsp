



<div class="col-md-12 stretch-card">
	<div class="card">
		<div class="card-body">
			<p class="card-title">Create new Category</p>
			<div class="table-responsive">
				<form action="../../CategoryServlet" method="post">
				<input name="action" type="hidden" value="add"/>
					<div class="form-group">
						<label for="exampleInputEmail1">Category Name</label> <input
							name="category_name" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Category Name"> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Category Description</label> <textarea
							name="category_description"  class="form-control"
							id="exampleInputPassword1" placeholder="Category description"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Create</button>
				</form>
			</div>
		</div>
	</div>
</div>