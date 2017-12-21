<html>
<head>

<title>| ATB Login |</title>

<script src="atb/reusable-components/script/jquery.min.js"></script>
<script src="atb/reusable-components/script/bootstrap.min.js"></script>



<link rel="stylesheet" href="atb/layouts/stylesheet/bootstrap.min.css">
<link rel="stylesheet" href="atb/reusable-components/stylesheet/app.css">
<link rel="stylesheet" href="atb/layouts/stylesheet/dashboard.css">
<link rel="stylesheet" href="atb/layouts/stylesheet/footer.css">
<link rel="stylesheet" href="atb/layouts/stylesheet/common.css">
<style>

img.img-thuimagembnail.atb-image {
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
			<img src="atb/layouts/images/ATBNEW.png"
				class="img-thumbnail atb-image" alt="Cinque Terre" width="304"
				height="236">
		</div>
		<br />
		<div class="row">
			<div class="col-md-8">
			<%
			String errorMessage = request.getParameter("errMsg");
			if(errorMessage!=null) 
			{
			%>
			<h3><font color="red"><%=request.getParameter("errMsg")%></font></h3>
			<%
			}
			%>
			
				<div class="panel panel-primary pannel-data">
					<div class="panel-heading">ATB Login Page</div>
					<div class="panel-body">				

						
							<form class="form-horizontal" role="form"
								action="loginProcess.do" name="loginForm" method="post">
								<div class="form-group">
									<label class="control-label col-sm-4" for="username">Username</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="userName" name = "userName"
											placeholder="Enter user name" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="comments">Password</label>
									<div class="col-sm-5">
										<input type="password" class="form-control" id="password" name = "password"
											placeholder="Enter password" required>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-5">
										<input type="submit" class="btn btn-primary" value="Submit"/>
										<input type="reset"  class="btn btn-primary" value = "Reset"/>
										<input type="submit" formnovalidate class="btn btn-primary" value="Forgot Password" onclick="form.action='passwordForgot.do'"/>
											
									</div>
								</div>
							</form>

							

						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>


