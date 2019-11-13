<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<meta charset="UTF-8">

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-lg-2 col-xlg-3" >
               <div class="card card-hover">
                   <a class="box bg-cyan text-center" href="charts.mc" role="button">
                       <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                       <h6 class="text-white">Chart 1</h6>
                   </a>
               </div>
        </div>
        <div class="col-md-6 col-lg-2 col-xlg-3">
            <div class="card card-hover">
                <a class="box bg-success text-center" role="button">
                    <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                    <h6 class="text-white">Chart 2</h6>
                </a>
            </div>
        </div>
        <div class="col-md-6 col-lg-2 col-xlg-3">
            <div class="card card-hover">
                <a class="box bg-warning text-center" role="button">
                    <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                    <h6 class="text-white">Chart 3</h6>
                </a>
            </div>
        </div>
        <div class="col-md-6 col-lg-2 col-xlg-3">
            <div class="card card-hover">
                <a class="box bg-cyan text-center" role="button">
                    <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                    <h6 class="text-white">Chart 4</h6>
                </a>
            </div>
        </div>
        <div class="col-md-6 col-lg-2 col-xlg-3">
            <div class="card card-hover">
                <a class="box bg-info text-center" role="button">
                    <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                    <h6 class="text-white">Chart 5</h6>
                </a>
            </div>
        </div>
     </div>
                   
<script>

function chart1(graph1){
	// Create the chart
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '주행거리 Top 10'
	    },
	    subtitle: {
	        text: ''
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: 'distance'
	        }

	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y:.1f}km'
	            }
	        }
	    },

	    tooltip: {
	        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
	    },

	    series: [
	        {
	            name: "Browsers",
	            colorByPoint: true,
	            data: graph1
	        }
	    ],
	   
	});
	
	
};// chart1 END

$(document).ready(function(){
	$.ajax({
		url:'drawgraph.mc',
		success:function(graph1){
			alert(graph1);
			chart1(eval(graph1));
		}
	})
});
</script>

<div class ="center_page">
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</div>
</div>