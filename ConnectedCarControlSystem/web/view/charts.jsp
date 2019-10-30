<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script>

function chart1(pdata){
	// Create the chart
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '주행거리 높은 순...'
	    },
	    subtitle: {
	        text: ''
	    },
	    xAxis: {
	        type: 'car_id'
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
	                format: '{point.y:.1f}%'
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
	            data: pdata
	        }
	    ],
	   
	});
	
	
};// chart1 END

$(document).ready(function(){
	$.ajax({
		url:'drawgraph.mc',
		success:function(pdata){
			chart1(pdata);
		}
	})
});
</script>

<div class ="center_page">
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</div>