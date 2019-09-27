<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<H1>Hello, ${name}!</H1>
<%--<h1>Log in to your account, please, or click "Sign up" to register</h1>--%>
<h2 class="err_msg"><c:out value="${requestScope.message}"/></h2>
<form action="${pageContext.request.contextPath}/auth" method="post">
    <input required autofocus placeholder="Your name" name="name"><br>
<%--    <input required placeholder="Your password" type="password" name="password"><br>--%>
    <button type="submit">Sign in</button>
</form>
<%--<a class="btn" href="${pageContext.request.contextPath}/reg">Sign up</a>--%>
</body>
</html>
