<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html dir="ltr">

<head>
<meta charset="EUC-KR">
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
						<b class="logo-icon"> <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
							<!-- Dark Logo icon --> <img src="assets/images/logo-sample.PNG"
							alt="homepage" class="light-logo" />
						</b> <span class="text-white p-l-10">ConnectedCarControlSystem</span>
						<span class="text-white p-l-10">회원 정보 수정</span>
					</div>

					<!-- Form -->
					<form id="update_form" class="form-horizontal">
						<div class="row p-b-20">
							<div class="col-12">
								<div class="mb-2">
									<span class="text-white">기본</span>
								</div>

								<!-- id -->
								<div class="text-left p-l-10">
									<span id="user_id_msg"></span>
								</div>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-success text-white"
											id="basic-addon1"><i class="ti-user"></i></span>
									</div>
									<input type="text" id="user_id" name="user_id" value="${userInfo.user_id }" class="form-control" 
									placeholder="아이디" aria-label="Username" aria-describedby="basic-addon1" readonly="readonly">
								</div>

								<!-- old pwd -->
								<div class="text-left p-l-10">
									<span id="user_old_pwd_check_msg"></span>
								</div>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-info text-white"
											id="basic-addon2"><i class="ti-pencil"></i></span>
									</div>
									<input type="password" id="user_old_pwd_check"
										name="old_pwd_check" class="form-control"
										placeholder="기존 비밀번호 " aria-label="Password_Check"
										aria-describedby="basic-addon1" required>
								</div>

								<!-- new pwd -->
								<div class="text-left p-l-10">
									<span id="user_pwd_msg"></span>
								</div>

								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-warning text-white"
											id="basic-addon2"><i class="ti-pencil"></i></span>
									</div>
									<input type="password" id="user_pwd" name="user_pwd"
										class="form-control" placeholder="새 비밀번호"
										aria-label="Password" aria-describedby="basic-addon1" required>
								</div>

								<!-- new pwd_check -->
								<div class="text-left p-l-10">
									<span id="user_pwd_check_msg"></span>
								</div>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-info text-white"
											id="basic-addon2"><i class="ti-pencil"></i></span>
									</div>
									<input type="password" id="user_pwd_check"
										name="pwd_check" class="form-control"
										placeholder="새 비밀번호 확인" aria-label="Password_Check"
										aria-describedby="basic-addon1" required>
								</div>
							</div>
						</div>

						<div class="row border-top border-secondary p-t-20 p-b-20">
							<div class="col-12">
								<div class="mb-2">
									<span class="text-white">인적사항</span>
								</div>

								<!-- name -->
								<div class="text-left p-l-10">
									<span id="user_name_msg"></span>
								</div>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-success text-white"
											id="basic-addon1"><i class="ti-user"></i></span>
									</div>
									<input type="text" id="user_name" name="user_name" value="${userInfo.user_name }" class="form-control" 
									placeholder="이름" aria-label="Username" aria-describedby="basic-addon1" readonly="readonly">
								</div>

								<!-- email -->
								<div class="text-left p-l-10">
									<span id="user_email_msg"></span>
								</div>
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<span class="input-group-text bg-danger text-white"
											id="basic-addon1"><i class="ti-email"></i></span>
									</div>
									<input type="text" id="user_email" name="user_email" value="${userInfo.user_email }"
										class="form-control" placeholder="이메일" aria-label="Email"
										aria-describedby="basic-addon1" required>
								</div>

								<!-- phone -->
								<div class="text-left p-l-10">
									<span id="user_phone_msg"></span>
								</div>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text bg-secondary text-white"
											id="basic-addon2"><i class="mdi mdi-cellphone"></i></span>
									</div>
									<input type="text" id="user_phone" name="user_phone"
										class="form-control" placeholder="전화번호" aria-label="Phone" value="${userInfo.user_phone }"
										aria-describedby="basic-addon1" required>
								</div>

								<!-- gender -->
								<div class="text-left p-l-10">
									<span id="user_gender_msg"></span>
								</div>
								<div class="form-group row mb-2">
									<label class="text-white col-md-3">성별</label>
									<div class="col-md-9">
										<c:choose>
											<c:when test="${userInfo.user_gender == 'male'}">
												<div class="custom-control custom-radio">
													<input type="radio" class="custom-control-input"
														id="user_gender1" name="user_gender" value="male" checked>
													<label class="text-white custom-control-label"
														for="user_gender1">남</label>
												</div>
												<div class="custom-control custom-radio">
													<input type="radio" class="custom-control-input"
														id="user_gender2" name="user_gender" value="female"
														disabled> <label
														class="text-white custom-control-label" for="user_gender2">여</label>
												</div>
											</c:when>
											<c:otherwise>
												<div class="custom-control custom-radio">
													<input type="radio" class="custom-control-input"
														id="user_gender1" name="user_gender" value="male" disabled>
													<label class="text-white custom-control-label"
														for="user_gender1">남</label>
												</div>
												<div class="custom-control custom-radio">
													<input type="radio" class="custom-control-input"
														id="user_gender2" name="user_gender" value="female"
														checked> <label
														class="text-white custom-control-label" for="user_gender2">여</label>
												</div>
											</c:otherwise>
										</c:choose>

									</div>
								</div>

								<!-- add -->
								<div class="text-left p-l-10">
									<span id="user_add_msg"></span>
								</div>
								<div class="form-group row mb-2">
									<label class="text-white col-md-3">주소</label>
									<div class="col-md-9">
										<select class="form-control" id="user_add" name="user_add">
											<option>${userInfo.user_add }</option>
											<optgroup label="서울특별시">
												<option value="Seoul">서울</option>
											</optgroup>
											<optgroup label="부산광역시">
												<option value="Busan">부산</option>
											</optgroup>
											<optgroup label="대구광역시">
												<option value="Daegu">대구</option>
											</optgroup>
											<optgroup label="인천광역시">
												<option value="Incheon">인천</option>
											</optgroup>
											<optgroup label="광주광역시">
												<option value="Gwangju">광주</option>
											</optgroup>
											<optgroup label="대전광역시">
												<option value="Daegeon">대전</option>
											</optgroup>
											<optgroup label="울산광역시">
												<option value="Ulsan">울산</option>
											</optgroup>
											<optgroup label="세종특별자치시">
												<option value="Sejong">세종</option>
											</optgroup>
											<optgroup label="경기도">
												<option value="Gyeonggi">경기</option>
											</optgroup>
											<optgroup label="강원도">
												<option value="Gangwon">강원</option>
											</optgroup>
											<optgroup label="충청북도">
												<option value="Chungbuk">충북</option>
											</optgroup>
											<optgroup label="충청남도">
												<option value="Chungnam">충남</option>
											</optgroup>
											<optgroup label="전라북도">
												<option value="Jeonbuk">전북</option>
											</optgroup>
											<optgroup label="전라남도">
												<option value="Jeonnam">전남</option>
											</optgroup>
											<optgroup label="경상북도">
												<option value="Gyeongbuk">경북</option>
											</optgroup>
											<optgroup label="경상남도">
												<option value="Gyeongnam">경남</option>
											</optgroup>
											<optgroup label="제주특별자치도">
												<option value="Jeju">제주</option>
											</optgroup>
										</select>
									</div>
								</div>

								<!-- birthdate -->
								<div class="text-left p-l-10">
									<span id="user_birthdate_msg"></span>
								</div>
								<div class="form-group row">
									<label class="text-white col-md-3">생일</label>

									<div class="col-md-9">
										<input type="text" id="user_birthdate" name="user_birthdate" value="${userInfo.user_birthdate }"
										class="form-control" placeholder="생일" aria-label="Phone" readonly="readonly">
									</div>
								</div>

								<input type="hidden" name="user_type" value="0">
							</div>
						</div>

						<div class="row border-top border-secondary p-t-20 p-b-20">
							<div class="col-12">
								<div class="form-group">
									<div class="mb-2">
										<button id="UpdateButton"
											class="btn btn-block btn-lg btn-secondary" type="button">Update</button>
										<button id="backButton"
											class="btn btn-block btn-lg btn-secondary" type="button">Back</button>
									</div>
								</div>
							</div>
						</div>
					</form>
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

		function checkAdd(add) {
			if (add != '주소') {
				$('#user_add_msg').html('');
				changeStyleOk('#user_add_msg');

				return true;
			}

			else {
				$('#user_add_msg').html('주소를 입력해 주세요');
				changeStyleNo('#user_add_msg');

				return false;
			}
		};

		function checkCellphone(cellphone) {
			var cellphonePattern = /^\d{2,3}-\d{3,4}-\d{4}$/;

			if (cellphonePattern.test(cellphone)) {
				$('#user_phone_msg').html('적절한 전화번호 입니다');
				changeStyleOk('#user_phone_msg');

				return true;
			}

			else {
				$('#user_phone_msg').html('적절하지 않은 전화번호 입니다');
				changeStyleNo('#user_phone_msg');

				return false;
			}
		}

		function checkEmail(email) {
			var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;

			if (emailPattern.test(email)) {
				$('#user_email_msg').html('적절한 이메일 입니다');
				changeStyleOk('#user_email_msg');

				return true;
			}

			else {
				$('#user_email_msg').html('적절하지 않은 이메일 입니다');
				changeStyleNo('#user_email_msg');

				return false;
			}
		};

		function checkPwd(pwd) {
			var numPattern = /[0-9]/;
			var lowerPattern = /[a-z]/;
			var upperPattern = /[A-Z]/;
			var specialPattern = /[~!@\#$%<>^&*]/;

			if (pwd != '') {
				if (!numPattern.test(pwd) || !lowerPattern.test(pwd)
						|| !upperPattern.test(pwd) || !specialPattern.test(pwd)) {
					$('#user_pwd_msg').html('대문자 + 소문자 + 숫자 + 특수기호를 포함해 주세요');
					changeStyleNo('#user_pwd_msg');

					return false;
				}

				else if (pwd.length < 8) {
					$('#user_pwd_msg').html('8 자리 이상 입력해 주세요');
					changeStyleNo('#user_pwd_msg');

					return false;
				}

				else {
					$('#user_pwd_msg').html('사용 가능한 비밀번호 입니다');
					changeStyleOk('#user_pwd_msg');

					return true;
				}
			}

			else {
				$('#user_pwd_msg').html('비밀번호를 입력해 주세요');
				changeStyleNo('#user_pwd_msg');

				return false;
			}
		};

		function checkOldPwd(old_pwd, old_pwd_check) {
			if (old_pwd == old_pwd_check) {
				$('#user_old_pwd_check_msg').html('패스워드가 일치합니다');
				changeStyleOk('#user_old_pwd_check_msg');
				return true;
			} else {
				$('#user_old_pwd_check_msg').html('패스워드가 일치하지 않습니다');
				changeStyleNo('#user_old_pwd_check_msg');
			}
		};

		function checkPwdCheck(pwd, pwdCheck) {
			if (pwd != pwdCheck) {
				$('#user_pwd_check_msg').html('패스워드가 일치하지 않습니다');
				changeStyleNo('#user_pwd_check_msg');

				return false;
			}

			else {
				$('#user_pwd_check_msg').html('패스워드가 일치합니다');
				changeStyleOk('#user_pwd_check_msg');

				return true;
			}
		};

		function checkTotal(pwd, pwd_check, email, phone, add) {
			var check_pwd = checkPwd(pwd);
			var check_pwd_check = checkPwdCheck(pwd, pwd_check);
			var check_email = checkEmail(email);
			var check_phone = checkCellphone(phone);
			var check_add = checkAdd(add);

			if (check_pwd == true && check_pwd_check == true && check_email == true 
					&& check_phone == true && check_add == true) {
				return true;
			}

			else {
				return false;
			}
		};

		$('#user_id').keyup(function() {
			var id = $('#user_id').val();
			checkId(id);
		});

		$('#user_pwd').keyup(function() {
			var pwd = $('#user_pwd').val();
			checkPwd(pwd);
		});

		$('#user_pwd_check').keyup(function() {
			var pwd = $('#user_pwd').val();
			var pwd_check = $('#user_pwd_check').val();

			checkPwdCheck(pwd, pwd_check);
		});

		$('#user_old_pwd_check').keyup(function() {
			var old_pwd = $('#user_old_pwd_check').val();
			var old_pwd_check = '${userInfo.user_pwd }';

			checkOldPwd(old_pwd, old_pwd_check);
		});

		$('#user_name').keyup(function() {
			var name = $('#user_name').val();
			checkName(name);
		});

		$('#user_email').keyup(function() {
			var email = $('#user_email').val();
			checkEmail(email);
		});

		$('#user_phone').keyup(function() {
			var phone = $('#user_phone').val();
			checkCellphone(phone);
		});

		$('#UpdateButton').click(
				function() {
					var id = '${userInfo.user_pwd }';
					var pwd = $('#user_pwd').val();
					var pwd_check = $('#user_pwd_check').val();
					var email = $('#user_email').val();
					var phone = $('#user_phone').val();
					var add = $('#user_add option:selected').val();

					if (checkTotal(pwd, pwd_check, email, phone, add)) {
						console.log('condition passed');

						$('#update_form').attr('action', 'editmyinfoImpl.mc');
						$('#update_form').attr('method', 'POST');
						$('#update_form').submit();
					}
				});

		$('#backButton').click(function() {
			location.href = "login.mc";
		});
	</script>
</body>

</html>