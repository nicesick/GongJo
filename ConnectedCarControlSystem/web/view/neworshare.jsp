<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html dir="ltr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="This Page is for managing Connected Car System">
<meta name="author" content="MultiCampus Team 1">

<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/images/favicon.png">
<title>Connected Car Control System - Team 1</title>

<!-- Custom CSS -->
<link href="dist/css/style.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
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
				<div>
					<div class="p-t-20 p-b-20">
						<b class="logo-icon"> 
						<!--You can put here icon as well // 
						<i class="wi wi-sunset"></i> //-->
							<!-- Dark Logo icon --> 
							<img src="assets/images/logo-sample.PNG" alt="homepage" class="light-logo" />
						</b> 
						<span class="text-white p-l-10">ConnectedCarControlSystem</span>
						<span class="text-white p-l-10">자동차 등록</span>

						<div class="row border-top border-secondary p-t-20 p-b-20">
							<div class="col-12">
								<a href="registercar.mc"> 
									<img alt="user" src="assets/images/addcar.png" 
									style="width: 45%; vertical-align: middle">
								</a>
								<a href="registerSharecar.mc"> 
									<img alt="user" src="assets/images/addcarshare.png" 
									style="width: 45%; vertical-align: middle">
								</a>
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
	<script
		src="assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<!-- ============================================================== -->
	<!-- This page Register scripts -->
	<!-- ============================================================== -->
	<script>
		$('[data-toggle="tooltip"]').tooltip();
		$(".preloader").fadeOut();

		$('.mydatepicker').datepicker();
		$('#datepicker-autoclose').datepicker({
			autoclose : true,
			todayHighlight : true
		});

		function changeStyleNo(id) {
			$(id).css('color', 'red');
			$(id).css('font-weight', 'normal');
		};

		function changeStyleOk(id) {
			$(id).css('color', 'green');
			$(id).css('font-weight', 'bold');
		};

		function checkCarId(id) {
			if (id != '') {
				$.ajax({
					url : 'checkCarId.mc',
					method : 'POST',
					data : {
						'id' : id
					},

					success : function(data) {
						if (data == 'OK') {
							$('#car_id_msg').html('동록 가능한 차량번호 입니다');
							changeStyleOk('#car_id_msg');
						}

						else {
							$('#car_id_msg').html('이미 등록된 차량번호 입니다');
							changeStyleNo('#car_id_msg');
						}
					}
				});
			} else {
				$('#car_id_msg').html('차량 번호를 입력해 주세요');
				changeStyleNo('#car_id_msg');

				return false;
			}
		}; //END CHECK CAR ID 

		function checkCarName(name) {
			if (name != '') {
				$('#car_name_msg').html('등록가능한 자동차 모델입니다');
				changeStyleOk('#car_name_msg');

				return true;
			}

			else {
				$('#car_name_msg').html('자동차 모델명을 입력해 주세요');
				changeStyleNo('#car_name_msg');

				return false;
			}
		}; //END CHECK CAR NAME

		function checkCarDisplacement(displacement) {
			if (displacement != '') {
				$('#car_displacement_msg').html('사용 가능한 배기량 입니다');
				changeStyleOk('#car_displacement_msg');

				return true;
			}

			else {
				$('#car_displacement_msg').html('자동차 배기량을 입력해 주세요');
				changeStyleNo('#car_displacement_msg');

				return false;
			}
		}; //END CHECK CAR DISPLACEMENT

		function checkCarColor(color) {
			if (color != '') {
				$('#car_color_msg').html('사용 가능한 색상 입니다');
				changeStyleOk('#car_color_msg');

				return true;
			}

			else {
				$('#car_color_msg').html('자동차 색상을 입력해 주세요');
				changeStyleNo('#car_color_msg');

				return false;
			}
		};

		$('#car_id').keyup(function() {
			var id = $('#car_id').val();
			checkCarId(id);
		});

		$('#car_name').keyup(function() {
			var name = $('#car_name').val();
			checkCarName(name);
		});

		$('#car_displacement').keyup(function() {
			var displacement = $('#car_displacement').val();
			checkCarDisplacement(displacement);
		});

		$('#car_color').keyup(function() {
			var color = $('#car_color').val();
			checkCarColor(color);
		});

		$('#signUpButton').click(function() {
			$('#registercar_form').attr('action', 'registercarImpl.mc');
			$('#registercar_form').attr('method', 'POST');
			$('#registercar_form').submit();

		});

		$('#backButton').click(function() {
			location.href = "main.mc";
		});
	</script>
</body>

</html>