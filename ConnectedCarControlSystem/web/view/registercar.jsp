<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html dir="ltr">

<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="This Page is for managing Connected Car System">
	<meta name="author" content="MultiCampus Team 1">
	
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>Connected Car Control System - Team 1</title>
    
    <!-- Custom CSS -->
    <link href="dist/css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
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
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center bg-dark">
            <div class="auth-box bg-dark border-top border-secondary">
                <div>
                    <div class="p-t-20 p-b-20">
						<b class="logo-icon">
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-sample.PNG" alt="homepage" class="light-logo" />
                        </b>
						<span class="text-white p-l-10">ConnectedCarControlSystem</span>
						<span class="text-white p-l-10">자동차 등록</span>
					</div>
					
                    <!-- Form -->
                    <form id="register_form" class="form-horizontal">
                                                
                        <div class="row border-top border-secondary p-t-20 p-b-20">
                        	<div class="col-12">
                        		<div class="mb-2">
                            		<span class="text-white">등록사항</span>
                            	</div>
                            	
                            	<div class="text-left p-l-10">
                                    	<span id="user_name_msg"></span>
                                </div>
                            	
                        		<!-- Car ID -->
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-success text-white" id="basic-addon1"><i class="ti-user"></i></span>
                                    </div>
                                    <input type="text" id="car_id" name="car_id" class="form-control" placeholder="자동차 번호" aria-label="Email" aria-describedby="basic-addon1" required>
                                </div>
                            	
                            	<div class="text-left p-l-10">
                                    	<span id="user_email_msg"></span>
                                </div>
                            	
                        		<!-- Car Name -->
                                <div class="input-group mb-2">
                                <label class="text-white col-md-3">모델명</label>
                                  <!--   <div class="input-group-prepend">
                                        <span class="input-group-text bg-danger text-white" id="basic-addon1"><i class="ti-email"></i></span>
                                    </div>  -->
                                    <div class="col-md-9">
                                    <input type="text" id="car_name" name="car_name" class="form-control" placeholder="자동차 모델명"  aria-describedby="basic-addon1" required>
                                    </div>
                                </div>
                             <!--    <div class="text-left p-l-10">
                                    	<span id="user_phone_msg"></span>
                                </div> -->
                                
                                
                                <!-- Car type -->
		                        <div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">자동차 종류</label>
			                        <div class="col-md-9">
			                            <select class="form-control" id="car_type" name="car_type">
			                                    <option value="CompactCar">경차</option>
			                                
			                                    <option value="SmallCar">소형차</option>
			                             
			                                    <option value="MidSizeCar">중형차</option>
			                              
			                                    <option value="FullSizedCar">대형차</option>
			                            </select>
			                        </div>
			                    </div>
                                
                                <!-- Fuel Type -->
                                     <div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">연료</label>
			                        <div class="col-md-9">
			                            <select class="form-control" id="car_fuel" name="car_fuel">
			                                    <option value="GasolineCar">휘발유</option>
			                                
			                                    <option value="DigelCar">경유</option>
			                             
			                                    <option value="LPGCar">LPG</option>
			                              
			                                    <option value="ElectiricCar">전기차</option>
			                                    
			                                    <option value="HybridCar">하이브리드</option>
			                            </select>
			                        </div>
			                    </div>
                                <!-- Displacement -->
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-success text-white" id="basic-addon1"><i class="ti-user"></i></span>
                                    </div>
                                    <input type="text" id="car_displacement" name="car_displacement" class="form-control" placeholder="배기량" aria-label="Email" aria-describedby="basic-addon1" required>
                                </div>
                            	
                            	<div class="text-left p-l-10">
                                    	<span id="user_email_msg"></span>
                                </div>
                                <!-- Car Color -->
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-success text-white" id="basic-addon1"><i class="ti-user"></i></span>
                                    </div>
                                    <input type="text" id="car_color" name="car_color" class="form-control" placeholder="자동차 색상" aria-label="Email" aria-describedby="basic-addon1" required>
                                </div>
                            	
                            	<div class="text-left p-l-10">
                                    	<span id="user_email_msg"></span>
                                </div>
                                
                                
                                <!-- Auto/Manual Type -->
                                <div class="form-group row mb-2">
			                        <label class="text-white col-md-3">Auto/Manual</label>
			                        <div class="col-md-9">
			                            <div class="custom-control custom-radio">
			                                <input type="radio" class="custom-control-input" id="car_auto" name="car_auto" value="auto" checked>
			                                <label class="text-white custom-control-label" for="car_auto">Auto</label>
			                            </div>
			                             <div class="custom-control custom-radio">
			                                <input type="radio" class="custom-control-input" id="car_auto" name="car_auto" value="manual">
			                                <label class="text-white custom-control-label" for="car_auto">Manual</label>
			                            </div>
			                        </div>
			                    </div>
		                        
		                        <div class="text-left p-l-10">
                                    	<span id="user_add_msg"></span>
                                </div>
		                        
		                        
			                    <div class="text-left p-l-10">
                                    	<span id="user_birthdate_msg"></span>
                                </div>
			                    <input type="hidden" name="user_type" value="0">
                        	</div>
                        </div>
                        
                        <div class="row border-top border-secondary p-t-20 p-b-20">
                            <div class="col-12">
                                <div class="form-group">
                                    <div class="mb-2">
                                        <button id="signUpButton" class="btn btn-block btn-lg btn-secondary" type="button">Sign Up</button>
                                        <button id="backButton" class="btn btn-block btn-lg btn-secondary" type="button">Back</button>
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
    <script src="assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

    <!-- ============================================================== -->
    <!-- This page Register scripts -->
    <!-- ============================================================== -->
    <script>
	    $('[data-toggle="tooltip"]').tooltip();
	    $(".preloader").fadeOut();
	    
	    $('.mydatepicker').datepicker();
	    $('#datepicker-autoclose').datepicker({
	        autoclose: true,
	        todayHighlight: true
	    });
    
    	function changeStyleNo(id) {
    		$(id).css('color','red');
    		$(id).css('font-weight','normal');
    	};
    
    	function changeStyleOk(id) {
    		$(id).css('color','green');
    		$(id).css('font-weight','bold');
    	};
    
    	function checkBirthdate(birthdate) {
    		if (birthdate != '') {
    			$('#user_birthdate_msg').html('');
    			changeStyleOk('#user_birthdate_msg');
    			
    			return true;
    		}
    		
    		else {
    			$('#user_birthdate_msg').html('생일을 입력해 주세요');
    			changeStyleNo('#user_birthdate_msg');
    			
    			return false;
    		}
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
    	
    	function checkGender(gender) {
    		if (gender != '') {
    			$('#user_gender_msg').html('');
    			changeStyleOk('#user_gender_msg');
    			
    			return true;
    		}
    		
    		else {
    			$('#user_gender_msg').html('성별을 입력해 주세요');
    			changeStyleNo('#user_gender_msg');
    			
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
    	
    	function checkName(name) {
    		if (name != '') {
    			$('#user_name_msg').html('적절한 이름입니다');
    			changeStyleOk('#user_name_msg');
    			
    			return true;
    		}
    		
    		else {
    			$('#user_name_msg').html('이름을 입력해 주세요');
    			changeStyleNo('#user_name_msg');
    			
    			return false;
    		}
    	};
    	
    	function checkPwd(pwd) {
    		var numPattern = /[0-9]/;
    		var lowerPattern = /[a-z]/;
    		var upperPattern = /[A-Z]/;
    		var specialPattern = /[~!@\#$%<>^&*]/;
    		
    		if (pwd != '') {
    			if (!numPattern.test(pwd) || !lowerPattern.test(pwd) || !upperPattern.test(pwd) || !specialPattern.test(pwd)) {
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
    
    	function checkId(id) {
    		if (id != '') {
    			$.ajax({
        			url : 'checkId.mc',
        			method : 'POST',
        			data : {
        				'id' : id
        			},
        		
        			success : function(data){
        				if (data == 'OK') {
        					$('#user_id_msg').html('사용 가능한 아이디입니다');
        					changeStyleOk('#user_id_msg');
        				}
        				
        				else {
        					$('#user_id_msg').html('이미 존재하는 아이디입니다');
        					changeStyleNo('#user_id_msg');
        				}
        			}
        		});
    		}
    		
    		else {
    			$('#user_id_msg').html('아이디를 입력해 주세요');
    			changeStyleNo('#user_id_msg');
				
    			return false;
    		}
    	};
	    
    	function checkIdFinal(id) {
    		var idSpan = $('#user_id_msg').html();
    		
    		if (idSpan == '사용 가능한 아이디입니다') {
    			return true;
    		}
    		
    		else {
    			return false;
    		}
    	}
    	
    	function checkTotal(id, pwd, pwd_check, name, email, phone, add, birthdate) {
    		var check_id = checkIdFinal(id);
    		var check_pwd = checkPwd(pwd);
    		var check_pwd_check = checkPwdCheck(pwd, pwd_check);
    		var check_name = checkName(name);
    		var check_email = checkEmail(email);
    		var check_phone = checkCellphone(phone);
    		var check_add = checkAdd(add);
    		var check_birthdate = checkBirthdate(birthdate);
    		
    		if (check_id == true && check_pwd == true && check_pwd_check == true 
    				&& check_name == true && check_email == true && check_phone == true 
    				&& check_add == true && check_birthdate == true) {
    			return true;
    		}
    		
    		else {
    			return false;	
    		}
    	};
    	
    	$('#user_id').keyup(function(){
    		var id = $('#user_id').val();
    		checkId(id);
    	});
    	
    	$('#user_pwd').keyup(function(){
    		var pwd = $('#user_pwd').val();
    		checkPwd(pwd);
    	});
    	
    	$('#user_pwd_check').keyup(function(){
    		var pwd = $('#user_pwd').val();
    		var pwd_check = $('#user_pwd_check').val();
    		
    		checkPwdCheck(pwd, pwd_check);
    	});
    	
    	$('#user_name').keyup(function(){
    		var name = $('#user_name').val();
    		checkName(name);
    	});
    	
    	$('#user_email').keyup(function(){
    		var email = $('#user_email').val();
    		checkEmail(email);
    	});
    	
    	$('#user_phone').keyup(function(){
    		var phone = $('#user_phone').val();
    		checkCellphone(phone);
    	});
    	
	    $('#signUpButton').click(function(){
	    	var id = $('#user_id').val();
	    	var pwd = $('#user_pwd').val();
	    	var pwd_check = $('#user_pwd_check').val();
	    	var name = $('#user_name').val();
	    	var email = $('#user_email').val();
	    	var phone = $('#user_phone').val();
	    	/* var gender = $('#user_gender').val(); */
	    	var add = $('#user_add option:selected').val();
	    	var birthdate = $('#datepicker-autoclose').val();
	    	
	    	if (checkTotal(id, pwd, pwd_check, name, email, phone, add, birthdate)) {
	    		console.log('condition passed');
		    	
	    		var dateFormat = birthdate.split('/');
    			$('#datepicker-autoclose').val(dateFormat[2] + '-' + dateFormat[0] + '-' + dateFormat[1]);
	    		
	    		$('#register_form').attr('action','registercarImpl.mc');
	    		$('#register_form').attr('method','POST');
	    		$('#register_form').submit();
	    	}
	    });
	    
	    $('#backButton').click(function(){
	    	location.href="login.mc";
	    });
    </script>
</body>

</html>