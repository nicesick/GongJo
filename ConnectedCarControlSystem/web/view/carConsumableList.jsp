<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row">
		<div class="col-12 d-flex no-block align-items-center">
			<h4 class="page-title">Tables</h4>
			<div class="ml-auto text-right">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="main.mc">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">consumable</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid">
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${carConsumable.car_id } : 소모품</h5>
					<div class="table-responsive">
						<table id="zero_config" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>소모품</th>
									<th>잔량</th>
									<th>최근교체날짜</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>필터</td>
									<td id="car_filter_alarm">${carStatus.car_filter }</td>
									<td id="date_filter">${carConsumable.date_filter }</td>
								</tr>
								<tr>
									<td>엔진오일</td>
									<td id="car_eng_oil_alarm">${carStatus.car_eng_oil }</td>
									<td id="date_eng_oil">${carConsumable.date_eng_oil }</td>
								</tr>
								<tr>
									<td>브레이크오일</td>
									<td id="car_brakeoil_alarm">${carStatus.car_brakeoil }</td>
									<td id="date_breakoil">${carConsumable.date_breakoil }</td>
								</tr>
								<tr>
									<td>엑셀오일</td>
									<td id="car_accoil_alarm">${carStatus.car_accoil }</td>
									<td id="date_accoil">${carConsumable.date_accoil }</td>
								</tr>
								<tr>
									<td>냉각수</td>
									<td id="car_coolwat_alarm">${carStatus.car_coolwat }</td>
									<td id="date_coolwat">${carConsumable.date_coolwat }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- End PAge Content -->
	<!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Container fluid  -->
<!-- ============================================================== -->
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

    
	function getData(car_id) {
		if (car_id != '') {
			$.ajax({
    			url : 'getRealTimeConsumable.mc',
    			method : 'POST',
    			data : {
    				'car_id' : car_id
    			},
    			
    			success : function(data){
    			var obj = JSON.parse(data);	
    				console.log(data);
    				console.log(obj.speed);
    				
   					$('#car_filter_alarm').html(obj.car_filter_alarm);
   					$('#car_eng_oil_alarm').html(obj.car_eng_oil_alarm);
   					$('#car_brakeoil_alarm').html(obj.car_brakeoil_alarm);
   					$('#car_accoil_alarm').html(obj.car_accoil_alarm);
   					$('#car_coolwat_alarm').html(obj.car_coolwat_alarm);
   					$('#date_filter').html(obj.date_filter);
   					$('#date_eng_oil').html(obj.date_eng_oil);
   					$('#date_breakoil').html(obj.date_breakoil);
   					$('#date_accoil').html(obj.date_accoil);
   					$('#date_coolwat').html(obj.date_coolwat);
    			}
    		});
		}
	};
	
    $(document).ready(function(){
    	var car_id = '${carConsumable.car_id }';
    	
    	setInterval(function(){
    		getData(car_id);
    	},3000);
    });
    
    </script>


