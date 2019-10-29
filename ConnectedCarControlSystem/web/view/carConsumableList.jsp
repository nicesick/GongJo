<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row">
		<div class="col-12 align-items-center">
			<h4 class="page-title">${selectcar } : 소모품</h4>
			<h5 class="page-title" id="dateHms"></h5>
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
									<td id="car_filter">${carStatus.car_filter }</td>
									<td id="date_filter">${carConsumable.date_filter }</td>
								</tr>
								<tr>
									<td>엔진오일</td>
									<td id="car_eng_oil">${carStatus.car_eng_oil }</td>
									<td id="date_eng_oil">${carConsumable.date_eng_oil }</td>
								</tr>
								<tr>
									<td>브레이크오일</td>
									<td id="car_brakeoil">${carStatus.car_brakeoil }</td>
									<td id="date_breakoil">${carConsumable.date_breakoil }</td>
								</tr>
								<tr>
									<td>엑셀오일</td>
									<td id="car_accoil">${carStatus.car_accoil }</td>
									<td id="date_accoil">${carConsumable.date_accoil }</td>
								</tr>
								<tr>
									<td>냉각수</td>
									<td id="car_coolwat">${carStatus.car_coolwat }</td>
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
    				console.log(data);
    				var obj = JSON.parse(data);
    				
   					$('#car_filter').html(obj.car_filter);
   					$('#car_eng_oil').html(obj.car_eng_oil);
   					$('#car_brakeoil').html(obj.car_brakeoil);
   					$('#car_accoil').html(obj.car_accoil);
   					$('#car_coolwat').html(obj.car_coolwat);
   					$('#date_filter').html(obj.date_filter);
   					$('#date_eng_oil').html(obj.date_eng_oil);
   					$('#date_breakoil').html(obj.date_breakoil);
   					$('#date_accoil').html(obj.date_accoil);
   					$('#date_coolwat').html(obj.date_coolwat);
   					$('#dateHms').html("갱신시간 : " + obj.car_date + " " + obj.car_hms);
    			}
    		});
		}
	};
	
   	var car_id = '${carConsumable.car_id }';
   	
   	setInterval(function(){
   		getData(car_id);
   	},1000);
</script>