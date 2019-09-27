<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<h1>Register your account, please, or click "Sign in" to log in</h1>
<h2 class="err_msg"><c:out value="${message}"/></h2>
<form action="${pageContext.request.contextPath}/reg" method="post">
    <input required autofocus placeholder="Your name" name="name"><br>
    <input required placeholder="Your email" type="email" name="email"><br>
    <input required placeholder="Your age" type="number" name="age"><br>
    <input required placeholder="Your password" type="password" name="password"><br>
    <button type="submit">Sign up</button>
</form>
<a class="btn" href="${pageContext.request.contextPath}/auth">Sign in</a>
</body>
</html>
