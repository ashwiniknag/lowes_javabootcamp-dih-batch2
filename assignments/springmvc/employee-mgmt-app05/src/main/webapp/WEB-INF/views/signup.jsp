<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Signup</title>
</head>

<body>
<p> ${exception.errorMsg}</p>
<br>
<h2>SignUp</h2>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<form:form method="POST" action="${contextPath}/adduser">
   <table>
    <tr>
        <td><form:label path="userName">UserName:</form:label></td>
        <td><form:input path="userName" /></td>
    </tr>
     <tr>
            <td><form:label path="emailID">Email-Id:</form:label></td>
            <td><form:input path="emailID" /></td>
     </tr>
    <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:password path="password" /></td>
    </tr>


    <tr>
        <td colspan="2">
            <input type="submit" value="Signup"/>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>