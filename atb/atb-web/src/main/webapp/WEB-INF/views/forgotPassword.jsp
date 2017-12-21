<html>
<head>

<title>| GTMT Forgot Password |</title>


<script src="gtmt/reusable-components/script/jquery.min.js"></script>
<script src="gtmt/reusable-components/script/angular.js"></script>
<script src="gtmt/reusable-components/script/bootstrap.min.js"></script>



<link rel="stylesheet" href="gtmt/layouts/stylesheet/bootstrap.min.css">
<link rel="stylesheet"
	href="gtmt/reusable-components/stylesheet/app.css">
<link rel="stylesheet" href="gtmt/layouts/stylesheet/dashboard.css">
<link rel="stylesheet" href="gtmt/layouts/stylesheet/footer.css">
<link rel="stylesheet" href="gtmt/layouts/stylesheet/common.css">
<style>
img.img-thuimagembnail.gtmt-image {
	margin-left: 30em;
}

.btn-primary {
	color: #fff;
	background-color: #124191;
	border-color: #124191;
}
</style>

</head>
<body>
	<br>
	<div class="container">
		<div class="row">
			<img src="gtmt/layouts/images/GTMT.PNG"
				class="img-thumbnail gtmt-image" alt="Cinque Terre" width="304"
				height="236">
		</div>
		<br />
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-primary pannel-data">
					<div class="panel-heading">Forgot Password</div>
					<div class="panel-body">
						<div class="col-md-8">
							<div class="panel-body">
								<form class="form-horizontal" role="form"
									action="forgotPassword.do" name="pwdForm" method="post">
									<div class="form-group">
										<label class="control-label col-sm-5" for="userName">User Name</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" placeholder="Enter user name" id="username" name = "userName" required>
										</div>										
									</div>

									<div class="form-group">
										<label class="control-label col-sm-5" for="email">Email Address</label>
										<div class="col-sm-5">
										<input type ="email" id="email" class="form-control" placeholder="Enter email address" required  name="email">
										</div>										
									</div>

									<div class="form-group">
										<div class="col-sm-offset-5 col-sm-5">
										<input type="submit" class="btn btn-primary" value="Submit">
										<input type="submit" formnovalidate class="btn btn-primary" value="Back" onclick="form.action='backToHome.do'"/>
											
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


