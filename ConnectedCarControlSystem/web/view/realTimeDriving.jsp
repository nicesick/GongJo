<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<style>

#rbox {
	box-sizing: border-box;
	width: 80px;
	height: 60px;
	margin-right: 5px;
	background-color: black;
	border-radius: 20px 20px;
	display: inline-block;
	float: left;
	text-align: center;
	font-size: 1em;
	color: white;
}

#rrbox {
	box-sizing: border-box;
	width: 110px;
	height: 60px;
	margin-right: 5px;
	background-color: black;
	border-radius: 10px 10px;
	display: inline-block;
	float: left;
	text-align: center;
	font-size: 1em;
	color: white;
}
</style>
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row">
		<div class="col-12 d-flex no-block align-items-center">
			<h4 class="page-title">${carStatus.car_id } : 실시간데이터</h4>
			<div class="ml-auto text-right">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="main.mc">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">RealTimeData</li>
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
		<div class="col-md-5">
			<div class="card">
				<div class="card-body text-center">
					<h4 class="card-title p-b-10">시동 관리 및 온도 관리</h4>
					<div
						style="display: inline-block; width: 320px; text-align: center">
						<div style="display: inline-block; float: left;">
							<img src="assets/images/car_top_view_on.png" width="135px">
						</div>

						<div style="display: inline-block; float: middle; width: 170px">
							<div style="position: relative;">
								<img src="assets/images/speed.png" width="160px">
								<div
									style="left: 60px; width: 50px; bottom: 50px; color: white; font-weight: bold; position: absolute;">
									<h1 id="car_speed"></h1>
								</div>
							</div>

							<div style="display: inline-block; width: 170px;">
								<div id="rbox">
									엑셀
									<h2 id="car_fuel"></h2>
								</div>
								<div id="rbox">
									브레이크
									<h2 id="car_bat"></h2>
								</div>

								<!-- <div
										style="display: inline-block; float: left; margin-right: 5px; background-color: black;">
										<img src="assets/images/excel.png" width="80px">
									</div>
									<div style="display: inline-block; float: left;">
										<img src="assets/images/brake.png" width="80px">
									</div> -->
							</div>
						</div>
					</div>

					<br></br>

					<div
						style="display: inline-block; width: 400px; text-align: center">
						<div
							style="display: inline-block; float: left; margin-right: 5px; padding: 10px;">
							<img src="assets/images/air-conditioner.png" width="60px">
							<h6>희망 온도</h6>
							<!-- form -->
						</div>

						<div
							style="display: inline-block; padding: 10px 0; width: 160px; vertical-align: middle;">
							<div style="float: left; text-align: center;">
								<img src="assets/images/cardistance.png" height="60px">
								<h6>운행 거리</h6>

							</div>
							<div
								style="display: inline-block; height: 80px; padding: 20px 10px; vertical-align: middle;">
								<h5 id="car_distance"></h5>
								<h5>km</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-7">
			<div class="card">
				<div class="card-body text-center">
					<h4 class="card-title p-b-10">실시간 데이터</h4>
					<div style="display: inline-block; width: 100%;">
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/atemperatureIn.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									온도
									<h2 id="car_temp"></h2>
								</div>
							</div>
						</div>
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/atemperatureOut.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									실외 온도
									<h2 id="car_ext_temperature"></h2>
								</div>
							</div>
						</div>

						<br></br>

						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/aco2In.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									CO2
									<h2 id="car_air"></h2>
								</div>
							</div>
						</div>
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/ahumidityIn.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									습도
									<h2 id="car_humidity"></h2>
								</div>
							</div>
						</div>

						<br></br>

						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/adustIn.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									미세먼지
									<h2 id="car_dust"></h2>
								</div>
							</div>
						</div>
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/adustOut.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									실외 미세먼지
									<h2 id="car_ext_dust"></h2>
								</div>
							</div>
						</div>

						<br></br>

						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/audustIn.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									초미세먼지
									<h2 id="car_finedust"></h2>
								</div>
							</div>
						</div>
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/audustOut.png" height="80px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									실외초미세먼지
									<h2 id="car_ext_finedust"></h2>
								</div>
							</div>
						</div>

						<br></br>

						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/afuel.png" width="95px" height="75px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									연료
									<h2 id="car_fuel"></h2>
								</div>
							</div>
						</div>
						<div style="display: inline-block;">
							<div style="display: inline-block; float: left;">
								<img src="assets/images/abattery.png" width="95px" height="75px">
							</div>
							<div
								style="display: inline-block; height: 80px; padding: 10px 5px;">
								<div id="rrbox">
									배터리
									<h2 id="car_bat"></h2>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->

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
<script
	src="assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<!-- ============================================================== -->
<!-- This page Register scripts -->
<!-- ============================================================== -->
<script>
	function getData(car_id) {
		if (car_id != '') {
			$.ajax({
				url : 'getRealTimeData.mc',
				method : 'POST',
				data : {
					'car_id' : car_id
				},

				success : function(data) {
					var obj = JSON.parse(data);
					console.log(data);
					console.log(obj.speed);

					$('#car_speed').html(obj.speed);
					$('#car_distance').html(obj.distance);
					$('#car_air').html(obj.air);
					$('#car_dust').html(obj.dust);
					$('#car_finedust').html(obj.finedust);
					$('#car_temp').html(obj.temp);
					$('#car_ext_dust').html(obj.ext_dust);
					$('#car_ext_finedust').html(obj.ext_finedust);
					$('#car_ext_temperature').html(obj.ext_temperature);
					$('#car_humidity').html(obj.humidity);
					$('#car_bat').html(obj.bat);
					$('#car_fuel').html(obj.fuel);
					$('#car_lat').html(obj.lat);
					$('#car_log').html(obj.log);
				}
			});
		}
	};

	var car_id = '${carStatus.car_id }';

	setInterval(function() {
		getData(car_id);
	}, 1000);
</script>
