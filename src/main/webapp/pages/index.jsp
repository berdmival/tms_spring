<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/pages/head.jsp" %>
<body>
<c:if test="${user != null}">
    <H1>Hello, <c:out value="${user.getName()}"/>!</H1>
    <hr size="2" color="black">

    <h1>Online users:</h1>
    <hr size="2" color="black">

    <c:forEach items="${onlineUsers}" var="onlineUser">
                <h2>${onlineUser}:</h2>
    <c:if test="${historyOfOnlineUsers.get(onlineUser.getId()).size() > 0}">
        <table border="1">
            <caption><h2>History:</h2></caption>
            <tr>
                <th>Date</th>
                <th>Number 1</th>
                <th>Number 2</th>
                <th>Action</th>
                <th>Result</th>
            </tr>
            <c:forEach items="${historyOfOnlineUsers.get(onlineUser.getId())}" var="historyItem">
                <tr>
                    <td>${historyItem.getCalcDateTime()}</td>
                    <td>${historyItem.getNum1()}</td>
                    <td>${historyItem.getNum2()}</td>
                    <td>${historyItem.getActionType()}</td>
                    <td>${historyItem.getResult()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${historyOfOnlineUsers.get(onlineUser.getId()).size() == 0}">
        <h2>History is empty</h2>
    </c:if>
    <hr size="2" color="black">
        </c:forEach>
</c:if>
<c:if test="${sessionScope.user == null}">
    <H1>Please, authorise first</H1>
</c:if>

<c:if test="${sessionScope.user == null}">
    <a class="btn" href="${pageContext.request.contextPath}/reg">Sign up</a>
</c:if>
<c:if test="${sessionScope.user == null}">
    <a class="btn" href="${pageContext.request.contextPath}/auth">Sign in</a>
</c:if>
<c:if test="${sessionScope.user != null}">
    <a class="btn" href="${pageContext.request.contextPath}/logout">Logout</a>
</c:if>
<c:if test="${sessionScope.user != null}">
    <a class="btn" href="${pageContext.request.contextPath}/calc">Calculator</a>
</c:if>
</body>
</html>
