<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ADMIN LOGIN</title>
</head>
<body style="background-color: LEMONCHIFFON">
<f:view>
<h1>Insert your credentials ADMIN</h1>
<h:form>
  <div>Email: <h:inputText value="#{adminController.email}" 
                     required="true"
                     requiredMessage="email is mandatory"
                     id="email"/> <h:message for="email" />
                     </div>
<div>Password: <h:inputSecret value="#{adminController.password}" 
                     required="true"
                     requiredMessage="password is mandatory"
                     id="password"/> <h:message for="password" />
                     </div>
<div>
	<h:commandButton  action="#{adminController.checkLogin}" value="Submit" />
</div>
</h:form>
</f:view>
</body>
</html>