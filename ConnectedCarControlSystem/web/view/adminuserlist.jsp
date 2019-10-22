<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

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
             <h5 class="card-title m-b-0" href="admincarlist.mc" role="button">관리자모드 차량제어</h5>&nbsp&nbsp&nbsp&nbsp&nbsp<h5 class="card-title m-b-0">관리자모드 유저관리</h5>
         </div>
         <table class="table">
         <thead>
             <tr>
                 <th scope="col">유저 ID</th>
                 <th scope="col">유저선택</th>
             </tr>
         </thead>
         <tbody>
           <tr>
               <td>
                   	id01
               </td>
               <td>
                   <button class="btn btn-cyan btn-sm" type="button" href="">Edit</button>
                   <button class="btn btn-danger btn-sm" type="button" href="">Delete</button><br>
                   	소유 차량 : 
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