<html>
<head>

<title>| GTMT Change Password |</title>


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
<script type="text/javascript">

  document.addEventListener("DOMContentLoaded", function() {

    // JavaScript form validation

    var checkPassword = function(str)
    {
      var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
      return re.test(str);
    };

    var checkForm = function(e)
    {
      if(this.username.value == "") {
        alert("Error: Username cannot be blank!");
        this.username.focus();
        e.preventDefault(); // equivalent to return false
        return;
      }
      re = /^\w+$/;
      if(!re.test(this.username.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        this.username.focus();
        e.preventDefault();
        return;
      }
      if(this.password.value != "" && this.password.value == this.confirmPassword.value) {
        if(!checkPassword(this.password.value)) {
          alert("The password you have entered is not valid!");
          this.password.focus();
          e.preventDefault();
          return;
        }
      } else {
        alert("Error: Please check that you've entered and confirmed your password!");
        this.password.focus();
        e.preventDefault();
        return;
      }
      alert("Both username and password are VALID!");
    };

    var myForm = document.getElementById("myForm");
    myForm.addEventListener("submit", checkForm, true);

    // HTML5 form validation

    var supports_input_validity = function()
    {
      var i = document.createElement("input");
      return "setCustomValidity" in i;
    }

    if(supports_input_validity()) {
      var usernameInput = document.getElementById("field_username");
      usernameInput.setCustomValidity(usernameInput.title);

      var passwordInput = document.getElementById("field_password");
      passwordInput.setCustomValidity(passwordInput.title);

      var confirmPasswordInput = document.getElementById("field_confirmPassword");

      // input key handlers

      usernameInput.addEventListener("keyup", function() {
        usernameInput.setCustomValidity(this.validity.patternMismatch ? usernameInput.title : "");
      }, false);

      passwordInput.addEventListener("keyup", function() {
        this.setCustomValidity(this.validity.patternMismatch ? passwordInput.title : "");
        if(this.checkValidity()) {
          confirmPasswordInput.pattern = this.value;
          confirmPasswordInput.setCustomValidity(confirmPasswordInput.title);
        } else {
          confirmPasswordInput.pattern = this.pattern;
          confirmPasswordInput.setCustomValidity("");
        }
      }, false);

      confirmPasswordInput.addEventListener("keyup", function() {
        this.setCustomValidity(this.validity.patternMismatch ? confirmPasswordInput.title : "");
      }, false);

    }

  }, false);

</script>
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
					<div class="panel-heading">Change Password</div>
					<div class="panel-body">
						<div class="col-md-8">
							<div class="panel-body">
								<form class="form-horizontal" role="form"
									action="changePassword.do" name="pwdForm" method="post">
									<div class="form-group">
										<label class="control-label col-sm-5" for="oldPassword">Old
											Password</label>
										<div class="col-sm-5">
											<input type="password" class="form-control" placeholder="Enter old password" id="oldPassword" name = "oldPassword" required>
										</div>										
									</div>

									<div class="form-group">
										<label class="control-label col-sm-5" for="viewUserName">New
											Password</label>
										<div class="col-sm-5">
										<input id="field_password" class="form-control" placeholder="Enter new password" title="Password must be between 6 and 20 characters" type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="password">
											
										</div>										
									</div>

									<div class="form-group">
										<label class="control-label col-sm-5" for="viewUserName">Confirm
											New Password</label>
										<div class="col-sm-5">
										 <input id="field_confirmPassword" class="form-control" placeholder="Confirm password" title="Passwords do not match." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="confirmPassword">
											
										</div>
										
									</div>
									<div class="form-group">
										<div class="col-sm-offset-5">
										<input type="submit" class="btn btn-primary" value="Submit">
											
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


