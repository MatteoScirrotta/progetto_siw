<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products</title>
</head>
<c:choose>
	<c:when test="${adminController.log}">
<body style="background-color: LIGHTGOLDENRODYELLOW">
	</c:when>
	<c:when test="${customerController.log}">
<body style="background-color: MISTYROSE">
	</c:when>
	<c:otherwise>
<body style="background-color: LEMONCHIFFON">
	</c:otherwise>
</c:choose>
<f:view>
<h1>Products</h1>
<h:form>
<table>
	<tr>
		<th>Name</th><th>Price</th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr><td>
		<h:commandLink action="#{productController.findProduct(product.id)}" value="#{product.name}">
		</h:commandLink>
		</td><td>${product.price}</td>
		</tr>
		</c:forEach>
</table>
<c:choose>
	<c:when test="${customerController.log}">
		<div><a href='<c:url value="/faces/homeCustomer.jsp" />'>Home</a></div>
	</c:when>
	<c:when test="${adminController.log}">
		<div><a href='<c:url value="/faces/adminHome.jsp" />'>Home</a></div>
	</c:when>
	<c:otherwise>
	<div><a href='<c:url value="/faces/index.jsp" />'>Go back</a></div>
	</c:otherwise>
</c:choose>
</h:form>
</f:view>
</body> 
</html>