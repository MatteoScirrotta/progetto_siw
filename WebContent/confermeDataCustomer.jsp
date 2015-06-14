<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Data Summary</title>
</head>
<body style="background-color: MISTYROSE">
<f:view>
<h:form>
<h1>Overview of your credenzials</h1>
<ul>
<li>${customerController.firstname}</li>
<li>${customerController.lastname}</li>
<li>${customerController.email}</li>
<li>${customerController.dateOfBirth}</li>
<li>${customerController.street},${customerController.streetNumber}</li>
<li>${customerController.city}</li>
<li>${customerController.country}</li>
<li>${customerController.state}</li>
<li>${customerController.zipcode}</li>
</ul>
<div>	<h:commandButton value="Conferme"  action="#{customerController.createCustomer}" />
	
</div>
</h:form>
</f:view>
</body>
</html>