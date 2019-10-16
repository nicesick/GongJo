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
                    <form id="registercar_form" class="form-horizontal">
                                                
                        <div class="row border-top border-secondary p-t-20 p-b-20">
                        	<div class="col-12">
                        		<div class="mb-2">
                            		<span class="text-white">등록사항</span>
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
                                <!-- <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-success text-white" id="basic-addon1"><i class="ti-user"></i></span>
                                    </div>
                                    <input type="text" id="car_id" name="car_id" class="form-control" placeholder="자동차 번호" aria-label="Email" aria-describedby="basic-addon1" required>
                                </div> -->
                        
                        		<!-- Car Name -->
                        		<div class="text-left p-l-10">
                                    	<span id="car_name_msg"></span>
                                </div>
                        		<div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">모델명</label>
			                        <div class="col-md-9">
			                           <input type="text" id="car_name" name="car_name" class="form-control" placeholder="자동차 모델명" aria-label="Email" aria-describedby="basic-addon1" required>
			                        </div>
			                    </div>
                                
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
                                <div class="text-left p-l-10">
                                    	<span id="car_fuel_msg"></span>
                                </div>
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
                                <div class="text-left p-l-10">
                                    	<span id="car_displacement_msg"></span>
                                </div>
                                <div class="text-left p-l-10">
                                    	<span id="car_displacement_msg"></span>
                                </div>
                                <div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">배기량</label>
			                        <div class="col-md-9">
			                           <input type="text" id="car_displacement" name="car_displacement" class="form-control" placeholder="배기량" aria-label="Email" aria-describedby="basic-addon1" required>
			                        </div>
			                    </div>
			                    
                                <!-- Car Color -->
                                <div class="text-left p-l-10">
                                    	<span id="car_color_msg"></span>
                                </div>
                                <div class="text-left p-l-10">
                                    	<span id="car_color_msg"></span>
                                </div>
                                <div class="form-group row mb-2">
		                        	<label class="text-white col-md-3">자동차 색상</label>
			                        <div class="col-md-9">
			                           <input type="text" id="car_color" name="car_color" class="form-control" placeholder="자동차 색상" aria-label="Email" aria-describedby="basic-addon1" required>
			                        </div>
			                    </div>
			                    
                                <!-- Auto/Manual Type -->
                                <div class="form-group row mb-2">
			                        <label class="text-white col-md-3">Auto/Manual</label>
			                        <div class="col-md-9">
			                            <div class="custom-control custom-radio">
			                                <input type="radio" class="custom-control-input" id="car_auto1" name="car_auto" value="auto" checked>
			                                <label class="text-white custom-control-label" for="car_auto1">Auto</label>
			                            </div>
			                             <div class="custom-control custom-radio">
			                                <input type="radio" class="custom-control-input" id="car_auto2" name="car_auto" value="manual">
			                                <label class="text-white custom-control-label" for="car_auto2">Manual</label>
			                            </div>
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

    	
    	function checkCarId(id) {
    		if (id != '') {
    			$.ajax({
        			url : 'checkCarId.mc',
        			method : 'POST',
        			data : {
        				'id' : id
        			},
        		
        			success : function(data){
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
    		}    		
    		else {
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
    	
		
    	$('#car_id').keyup(function(){
    		var id = $('#car_id').val();
    		checkCarId(id);
    	});
    	
    	$('#car_name').keyup(function(){
    		var name = $('#car_name').val();
    		checkCarName(name);
    	});
    	
    	$('#car_displacement').keyup(function(){
    		var displacement = $('#car_displacement').val();
    		checkCarDisplacement(displacement);
    	});
    	
    	$('#car_color').keyup(function(){
    		var color = $('#car_color').val();
    		checkCarColor(color);
    	});
    	
    	
	    $('#signUpButton').click(function(){
	    		$('#registercar_form').attr('action','registercarImpl.mc');
	    		$('#registercar_form').attr('method','POST');
	    		$('#registercar_form').submit();
	    	
	    });
	    
	    $('#backButton').click(function(){
	    	location.href="main.mc";
	    });
    </script>
</body>

</html>