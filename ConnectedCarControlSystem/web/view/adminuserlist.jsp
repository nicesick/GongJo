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
<script>
$('#DeleteButton').click(
		function(){
			var id = '${user.user_id}';
			$('#delete_form').attr('action', 'adminuserdelete.mc');
			$('#delete_form').attr('method', 'POST');
			$('#delete_form').submit();
		});
</script>
<form id="delete_form">
<div class="col-12">
     <div class="card">
         <nav aria-label="breadcrumb">
             <ol class="breadcrumb">
                 <li class="breadcrumb-item"><a href="admincarlist.mc">관리자모드 차량조회</a></li>
                 <li class="breadcrumb-item"><a href="adminuserlist.mc">관리자모드 유저관리</a></li>
             </ol>
         </nav>
         <table class="table">
         <thead>
             <tr>
                 <th scope="col">유저 ID</th>
                 <th scope="col">유저관리</th>
             </tr>
         </thead>
         <tbody>
           <c:forEach var="user" items="#{adminusers}">
           <tr>
               <td>
               ${user.user_id}    	
               </td>
               <td>
                  <%--  <button class="btn btn-cyan btn-sm" type="button" href="adminuseredit.mc?id=${user.user_id}">Edit</button> --%>
                   <button id="DeleteButton">Delete</button><br>
                   	소유 차량 : <c:forEach var="car" items="#{carInfo}">${car.car_id} &nbsp
                   	</c:forEach>
                   	
               </td>
           </tr>
               </c:forEach>
           </tbody>
         </table>
      
     </div>
 </div>
 </form>
 
                         
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