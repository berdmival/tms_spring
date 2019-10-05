<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<h1>Log in to your account, please, or click "Sign up" to register</h1>
<h2 class="err_msg"><c:out value="${message}"/></h2>

<spring:form action="/auth" method="post" modelAttribute="authData">
    <spring:input autofocus="true" placeholder="Your email" type="email" path="email"/>
    <spring:errors path="email"/> <br>

    <spring:input placeholder="Your password" type="password" path="password"/>
    <spring:errors path="password"/> <br>

    <spring:button>Sign in</spring:button>
</spring:form>

<a class="btn" href="/reg">Sign up</a>
</body>
</html>
