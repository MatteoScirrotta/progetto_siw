<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>NEW ADMIN</title>
</head>
<body style="background-color: LIGHTGOLDENRODYELLOW">
<f:view>
<h:form>
<h1>Register new admin</h1>
<h2> Fields marked with '*' are mandatory</h2>
<div><em>Email*</em>*: <h:inputText value="#{adminController.email}" 
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email" />    you will use your email to enter in your admin account</div>
<div><em>Password*</em>*: <h:inputText value="#{adminController.password}" 
                     required="true"
                     requiredMessage="Password is mandatory"
                     id="password"/> <h:message for="password" />    you will use your password to enter in your admin account</div>
<div>Firstname*: <h:inputText value="#{adminController.firstname}" 
                     required="true"
                     requiredMessage="Firstname is mandatory"
                     id="firstname"/> <h:message for="firstname" /></div>
<div>Lastname*: <h:inputText value="#{adminController.lastname}" 
                     required="true"
                     requiredMessage="Lastname is mandatory"
                     id="lastname"/> <h:message for="lastname" /></div>
<div>	<h:commandButton value="Forward"  action="#{adminController.createAdmin}"/></div>
</h:form>
</f:view>
</body>
</html>