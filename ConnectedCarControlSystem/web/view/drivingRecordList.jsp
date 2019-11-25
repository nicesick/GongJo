<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb">
	<div class="row">
		<div class="col-12 d-flex no-block align-items-center">
			<h4 class="page-title">DrivingRecord</h4>
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
	<div class="row">
		<div class="card col-md-12">
			<div class="card-body">
				<h5 class="card-title m-b-10">운행기록</h5>
				<input id="selectDate" type="date" value="">
				
				<div class="table-responsive">
					<table id="zero_config" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>기록시간</th>
								<th>주행시간</th>
								<th>주행거리</th>
								<th>소모연료량</th>
								<th>평균속력</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End Container fluid  -->
<!-- ============================================================== -->

<script>
	function setTable(data) {
		$('#zero_config tbody').html('');
		
		var parsedData = JSON.parse(data);
		var tableForm = '';
		
		$(parsedData).each(function(index, item){
			var tableHms = '<td>' + item.hms + '</td>';
			var tableTimeSpent = '<td>' + item.timeSpent + '</td>';
			var tableDistance = '<td>' + item.distance + '</td>';
			var tableFuelSpent = '<td>' + item.fuelSpent + '</td>';
			var tableSpeedAvg = '<td>' + item.speedAvg + '</td>';
			
			tableForm += '<tr>' + tableHms + tableTimeSpent + tableDistance + tableFuelSpent + tableSpeedAvg + '</tr>';
			
			$('#zero_config tbody').html(tableForm);
		});
	}

	$('#selectDate').change(function(){
		var date = $('#selectDate').val();
		var car_id = '${selectcar}';
		
		if (date != "" && car_id != null && car_id != "") {
			console.log(date);
			
			$.ajax({
				url : 'getDrivingRecordFromHive.mc',
				method : 'POST',
				data : {
					'car_id' : car_id,
					'date' : date
				},
				
				success : function(data) {
					setTable(data);			
				}
			});
		}
	});
</script>