<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
img {
  width: auto;
  height: 60px;
  border: 5px solid black;
}
</style>
<head>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="../assets/images/favicon.png">
<title>Connected Car Control System - Team 1</title>

<!-- Custom CSS -->
<link href="../assets/libs/flot/css/float-chart.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../dist/css/style.min.css" rel="stylesheet">
<!-- T-map -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&format=javascript&appkey=dbd0828d-01af-45cb-956b-a170291f8d2b"></script>
        <script>
        var map;
    	// 페이지가 로딩이 된 후 호출하는 함수입니다.
    	function initTmap(){
    		// map 생성
    		// Tmapv2.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
    		map = new Tmapv2.Map("map_div",  // "map_div" : 지도가 표시될 div의 id
    		{
    			center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841), // 지도 초기 좌표
    			width: "100%", // map의 width 설정
    			height: "400px" // map의 height 설정
    		});
    		 
    		var marker = new Tmapv2.Marker({
    			position: new Tmapv2.LatLng(37.566481622437934,126.98452302169841),
    			map: map
    		});
    		var marker = new Tmapv2.Marker({
    			position: new Tmapv2.LatLng(37.566481622437934,126.98502302169841),
    			map: map
    		});
    		var marker = new Tmapv2.Marker({
    			position: new Tmapv2.LatLng(37.566481622437934,126.98552302169841),
    			map: map
    		});
    		
    	}
    	// 맵 생성 실행
    	initTmap();
</script>
		
		
</head>
<!-- ============================================================== -->
<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid">
	<!-- ============================================================== -->
	<!-- Sales Cards  -->
	<!-- ============================================================== -->
	<div class="row el-element-overlay">
<div class="col-12">
     <div class="card">
         <nav aria-label="breadcrumb">
             <ol class="breadcrumb">
                 <li class="breadcrumb-item"><a href="admincarlist.mc">관리자모드 차량조회</a></li>
                 <li class="breadcrumb-item"><a href="adminuserlist.mc">관리자모드 유저관리</a></li>
             </ol>
         </nav>
         
         <body onload="initTmap()">
        <div id="map_div">
        </div>        
    </body>     
    		
         
         <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">차량 목록</h5>
                            <div class="row">
                               <%--  <c:forEach var="car" items="#{carInfo}"> --%>
                                <div class="col-md-3 col-sm-12">
                                    <button class="btn btn-lg btn-block btn-outline-info" id="ts-info" type="button">Car1</button>
                                </div>
                                <%-- </c:forEach> --%>
                            </div>
                        </div>
                    </div>
                </div>
		 
		
         
           
	
	
     </div>
 </div>
 
 
                         
	<!-- ============================================================== -->
	<!-- Recent comment and chats -->
	<!-- ============================================================== -->
</div>
</div>
<!-- Charts js Files -->
	<script src="assets/libs/flot/excanvas.js"></script>
	<script src="assets/libs/flot/jquery.flot.js"></script>
	<script src="assets/libs/flot/jquery.flot.pie.js"></script>
	<script src="assets/libs/flot/jquery.flot.time.js"></script>
	<script src="assets/libs/flot/jquery.flot.stack.js"></script>
	<script src="assets/libs/flot/jquery.flot.crosshair.js"></script>
	<script src="assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	<script src="dist/js/pages/chart/chart-page-init.js"></script>

<!-- ============================================================== -->
<!-- End Container fluid  -->
<!-- ============================================================== -->