<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<c:choose>
	<c:when test="${adminController.log}">
<body style="background-color: LIGHTGOLDENRODYELLOW">
	</c:when>
	<c:when test="${customerController.log}">
<body style="background-color: pink">
	</c:when>
	<c:otherwise>
<body>
	</c:otherwise>
</c:choose>
<f:view>
<h1>${orderController.orderLine.product.name}</h1>
<h2>Details</h2>
<div>Id: ${orderController.orderLine.product.id}</div>
<div>Code: ${orderController.orderLine.product.code}</div>
<div>Unit Price: ${orderController.orderLine.product.price}</div>
<div>Description: ${orderController.orderLine.product.description}</div>
<h:form>
<h:commandButton action="#{orderController.goBack}" value="Go back" />
</h:form>
</f:view>
</body>
</html>