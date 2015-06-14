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
<body style="background-color: LEMONCHIFFON">
<f:view>
<h1>Welcome in SuperMarket</h1>
<ul>
	<li><a href='<c:url value="/faces/login.jsp" />'>Login</a></li>
	<li><a href='<c:url value="/faces/loginAdmin.jsp" />'>Login as administrator</a></li>
	<li><a href='<c:url value="/faces/newCustomer.jsp" />'>If you don't have an account register</a></li>
	<li><h:form><h:commandLink action="#{productController.listProducts}"  value="Catalog" />
				</h:form></li>
</ul>
</f:view>
</body>
</html>