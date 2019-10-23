<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ============================================================== -->
<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid">
	<!-- ============================================================== -->
	<!-- Sales Cards  -->
	<!-- ============================================================== -->
	<div class="row el-element-overlay">
			<c:forEach var="car" items="#{carInfo}">
				<div class="col-lg-3 col-md-6">
					<div class="card">
						<div class="el-card-item">
							<div class="el-card-avatar el-overlay-1">
								<img alt="user" src="assets/images/thecar.png">
								<div class="el-overlay">
									<ul class="list-style-none el-info">
										<li class="el-item"><a
											class="btn default btn-outline image-popup-vertical-fit el-link"
											href="assets/images/big/img1.jpg"><i
												class="mdi mdi-magnify-plus"></i></a></li>
										<li class="el-item"><a
											class="btn default btn-outline el-link"
											href="selectcar.mc?id=${car.car_id}"><i
												class="mdi mdi-link"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="el-card-content">
								<h4 class="m-b-0">${car.car_id}</h4>
								<span class="text-muted">${car.car_name}</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>


		<div class="col-lg-3 col-md-6">
			<div class="card">
				<div class="el-card-item">
					<div class="el-card-avatar el-overlay-1">
						<a href="registercar.mc"><img alt="user"
							src="assets/images/addcar.png"></a>
						<!-- <div class="el-overlay"  >
                                    </div> -->
					</div>
					<!-- <div class="el-card-content">
                                    <h4 class="m-b-0">차량 추가</h4>
                                </div> -->
				</div>
			</div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Recent comment and chats -->
	<!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Container fluid  -->
<!-- ============================================================== -->