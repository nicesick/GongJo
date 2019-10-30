<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html dir="ltr">


<head>
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="This Page is for managing Connected Car System">
<meta name="author" content="MultiCampus Team 1">
	<style>
		#webbody {
			background-image: url("/web/assets/images/ConnectedCar1.jpg") !important;
		}
	</style>

<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/images/favicon.png">
<title>Connected Car Control System - Team 1</title>

<!-- Custom CSS -->
<link href="dist/css/style.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body id="webbody">
	<div class="main-wrapper">
		<!-- ============================================================== -->
		<!-- Preloader - style you can find in spinners.css -->
		<!-- ============================================================== -->
		<div class="preloader">
			<div class="lds-ripple">
				<div class="lds-pos"></div>
				<div class="lds-pos"></div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- Preloader - style you can find in spinners.css -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Login box.scss -->
		<!-- ============================================================== -->
		<div
			class="auth-wrapper d-flex no-block justify-content-center align-items-center bg-dark">
			<div class="auth-box bg-dark border-top border-secondary">
				<div id="loginform">
					<div class="p-t-20 p-b-20">
						<b class="logo-icon">
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-sample.PNG" alt="homepage" class="light-logo" />
                        </b>
						<span class="text-white p-l-10">ConnectedCarControlSystem</span>
						<span class="text-white p-l-10">로그인</span>
					</div>
					
					<div class="row p-b-20">
						<div class="col-12">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text bg-success text-white"
										id="basic-addon1"><i class="ti-user"></i></span>
								</div>
								<input type="text" id="user_id" class="form-control"
									placeholder="아이디" aria-label="Username"
									aria-describedby="basic-addon1" required>
							</div>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<span class="input-group-text bg-warning text-white"
										id="basic-addon2"><i class="ti-pencil"></i></span>
								</div>
								<input type="password" id="user_pwd" class="form-control"
									placeholder="비밀번호" aria-label="Password"
									aria-describedby="basic-addon1" required>
								<input type="hidden" id="token" value="NULL">
							</div>
						</div>
					</div>
					
					<div class="row border-top border-secondary">
						<div class="col-12">
							<div class="form-group">
								<div class="p-t-20">
									<button class="btn btn-info" id="registerButton" type="button">
										<i class="fa fa-lock m-r-5"></i> Register
									</button>
					
									
									<button id="loginimpl" class="btn btn-success float-right" type="button">Login</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- Login box.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper scss in scafholding.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper scss in scafholding.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Right Sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Right Sidebar -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- All Required js -->
	<!-- ============================================================== -->
	
	<script src="assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- ============================================================== -->
	<!-- This page plugin js -->
	<!-- ============================================================== -->

	<script>
		$('[data-toggle="tooltip"]').tooltip();
		$(".preloader").fadeOut();

		
		// ============================================================== 
		// Login and Recover Password 
		// ============================================================== 
		
		$('#registerButton').click(function(){
			location.href = "register.mc";
		});
		
		
		$('#loginimpl').click(function(){
			var id = $('#user_id').val();
			var pwd = $('#user_pwd').val();
			var token = $('#token').val();
			
			if (id != '' && pwd != '') {
				$.ajax({
					url : 'loginImpl.mc',
					method : 'POST',
					
					data : {
						'id' : id,
						'pwd' : pwd,
						'token' : token
					},
					
					success : function(data) {
						if (data == 'LoginSuccess') {
							location.href = 'main.mc';
						}
						
						else {
							alert('사용자 정보가 일치하지 않습니다');
						}
					}
				});
			}
			
			else {
				alert('사용자 정보를 입력해 주세요');
			}
		});
	</script>
</body>
</html>