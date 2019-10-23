<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
img {
  width: auto;
  height: 60px;
  border: 1px solid red;
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
                <div class="card-body">
                    <h5 class="card-title m-b-0">관리자모드 차량제어</h5>
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">차량 이름</th>  <!-- 차량 이름과 사진(작은 사진) 넣기  -->
                            <th scope="col">차량 제어</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <img href="web/assets/images/thecar.png"><span class="badge badge-dark">CAR 1</span>
                            </td>
                            <td>
                                <i class="fas fa-chevron-up"></i>
                                <button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 1 : STATUS
                                </button><i class="fas fa-chevron-down"></i>&nbsp&nbsp&nbsp
                                <i class="fas fa-chevron-up"></i><button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 2 : STATUS
                                </button><i class="fas fa-chevron-down"></i><br>
                                <i class="fas fa-chevron-up"></i>
                                <button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 3 : STATUS
                                </button><i class="fas fa-chevron-down"></i>&nbsp&nbsp&nbsp
                                <i class="fas fa-chevron-up"></i><button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 4 : STATUS
                                </button><i class="fas fa-chevron-down"></i><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="badge badge-dark">CAR 2</span>
                            </td>
                            <td>
                                <i class="fas fa-chevron-up"></i>
                                <button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 1 : STATUS
                                </button><i class="fas fa-chevron-down"></i>&nbsp&nbsp&nbsp
                                <i class="fas fa-chevron-up"></i><button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 2 : STATUS
                                </button><i class="fas fa-chevron-down"></i><br>
                                <i class="fas fa-chevron-up"></i>
                                <button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 3 : STATUS
                                </button><i class="fas fa-chevron-down"></i>&nbsp&nbsp&nbsp
                                <i class="fas fa-chevron-up"></i><button title="" class="btn btn-secondary" type="button" data-toggle="tooltip" data-placement="top" data-original-title="Tooltip on top">
                                  CONTROL 4 : STATUS
                                </button><i class="fas fa-chevron-down"></i><br>
                            </td>
                        </tr>
                       
                  </tbody>
                </table>
                
                
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