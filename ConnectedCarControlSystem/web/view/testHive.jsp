<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="car" items="${hiveInfo }">
	<h1>${car.car_id }, ${car.car_date }</h1>
</c:forEach>