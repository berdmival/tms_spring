<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<h1>Register your account, please, or click "Sign in" to log in</h1>
<h2 class="err_msg"><c:out value="${message}"/></h2>

<spring:form action="/reg" method="post" modelAttribute="newUser">
    <spring:input autofocus="true" placeholder="Your name" path="name"/>
    <spring:errors path="name"/><br>

    <spring:input placeholder="Your email" type="email" path="email"/>
    <spring:errors path="email"/><br>

    <spring:input placeholder="Your age" type="number" path="age"/>
    <spring:errors path="age"/><br>

    <spring:input placeholder="Your password" type="password" path="password"/>
    <spring:errors path="password"/><br>

    <spring:button>Sign up</spring:button>
</spring:form>

<a class="btn" href="${pageContext.request.contextPath}/auth">Sign in</a>
</body>
</html>
