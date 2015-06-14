<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#Button { width: 100px; height: 30px; background: #0000FF; border-style: none; cursor: pointer; margin: 150px auto; }
#Button:hover { color: #CCC; background: #000FFF; }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ADMIN ${adminController.admin.firstname}'S HOMEPAGE</title>
</head>
<c:if test="${adminController.log}">
<body style="background-color: LIGHTGOLDENRODYELLOW">
<h1> Hi Admin ${adminController.admin.firstname}</h1>
<f:view>
<h:form>
<ul>

<li><h:commandButton value="Add product to the catalog" action="#{providerController.addProduct}"></h:commandButton></li>
<li><h:commandButton value="Have a look of our catalog" action="#{productController.listProducts}" /></li>

<li><h:commandButton value="List of all orders" action="#{orderController.listOrders}" /></li>
	<li><h:commandButton value="Add admin to the system" action="#{adminController.newAdmin}" /></li>
	<li><h:commandButton value="Add provider to the system" action="#{providerController.newProvider}" /></li>
	<li><h:commandButton value="Have a look of our providers" action="#{providerController.getAllProviders}" /></li>

</ul>


<h2></h2>
<h:commandButton value="Logout" action="#{adminController.logout}" />
</h:form>
</f:view>
</body>
</c:if>
</html>