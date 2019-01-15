<%-- 
    Document   : login
    Created on : Nov 25, 2018, 1:07:49 AM
    Author     : C13
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/plugin3/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/plugin3/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/plugin3/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/plugin3/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	
	<div class="container-login100" style="background-image: url('resources/plugin3/images/bg-01.jpg');">
		<div class="transition">
                    <form class="login100-form validate-form"  method="post" action="perform_login">
				<span class="login100-form-title p-b-37">
					Sign In
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
					<input class="input100" type="text" id="usename" name="usename" required="true" placeholder="username or email">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="password" id="userpassword" name="userpassword" required="true" placeholder="password">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<button class="login100-form-btn"  name="Submit" id="loginbutton" value="Login" type="Submit">
						Sign In
					</button>
				</div>

				<div class="text-center">
					<a href="/retailersManagement" class="txt2 hov1">
						Home
					</a>
				</div>

				<div class="flex-c p-b-112">
					<a href="#" class="login100-social-item">
						<i class="fa fa-facebook-f"></i>
					</a>

					<a href="#" class="login100-social-item">
						<img src="images/icons/icon-google.png" alt="GOOGLE">
					</a>
				</div>

				<div class="text-center">
					<a href="signup" class="txt2 hov1">
						Sign Up
					</a>
				</div>
			</form>

			
		</div>
	</div>
	
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/plugin3/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/daterangepicker/moment.min.js"></script>
	<script src="resources/plugin3/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="resources/plugin3/js/main.js"></script>

</body>
</html>