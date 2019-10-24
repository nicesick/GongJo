<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html dir="ltr">

<head>
    <meta charset="UTF-8">
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
						<span class="text-white p-l-10">공유 자동차 등록</span>
					</div>
					
                    <!-- Form -->
                    <form id="registersharecar_form" class="form-horizontal">
                                                
                        <div class="row border-top border-secondary p-t-20 p-b-20">
                        	<div class="col-12">
                        		<div class="mb-2">
                            		<span class="text-white">등록사항</span>
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
								
                        		<!-- Car ID -->
                        		<div class="text-left p-l-10">
                                    	<span id="car_id_msg"></span>
                                </div>
		                        
                        		<div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">자동차 번호</label>
			                        <div class="col-md-9">
			                           <input type="text" id="car_id" name="car_id" class="form-control" placeholder="자동차 번호" aria-label="Email" aria-describedby="basic-addon1" required>
			                        </div>
			                    </div>
			                    
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

    	
    	function checkCarId(id, uuid) {
    		if (id != '') {
    			$.ajax({
        			url : 'checkShareCarId.mc',
        			method : 'POST',
        			data : {
        				'id' : id,
        				'uuid' : uuid
        			},
        		
        			success : function(data){
        				if (data == 'Exist'){
        					$('#car_id_msg').html('이미 등록되어있습니다.');
        					changeStyleNo('#car_id_msg');
        				}
        				else  if (data == 'OK') {
        					$('#car_id_msg').html('등록 가능한 차량번호 입니다');
        					changeStyleOk('#car_id_msg');
        				}
        				
        				else {
        					$('#car_id_msg').html('존재하지않는 차량번호 입니다');
        					changeStyleNo('#car_id_msg');
        				}
        			}
        		});
    		}    		
    		else {
    			$('#car_id_msg').html('차량 번호를 입력해 주세요');
    			changeStyleNo('#car_id_msg');
				
    			return false;
    		}
    	}; //END CHECK CAR ID 
    	
    	$('#car_id').keyup(function(){
    		var id = $('#car_id').val();
    		var uuid = $('#user_id').val();
    		checkCarId(id,uuid);
    	});
    	
	    $('#signUpButton').click(function(){
	    		$('#registersharecar_form').attr('action','registersharecarImpl.mc');
	    		$('#registersharecar_form').attr('method','POST');
	    		$('#registersharecar_form').submit();
	    	
	    });
	    
	    $('#backButton').click(function(){
	    	location.href="main.mc";
	    });
    </script>
</body>

</html>