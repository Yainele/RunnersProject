<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<%@ include file="header.jsp" %>
<div class="content-wrapper">
    <table>
        <thead>
        <th>ID</th>
        <th>location_name</th>
        <th>location_description</th>
        <th>longitude</th>
        <th>latitude</th>
        </thead>
        <c:forEach items="${allDefiniteLocations}" var="loc">
            <tr>
                <td>${loc.id}</td>
                <td>${loc.location_name}</td>
                <td>${loc.location_description}</td>
                <td>${loc.longitude}</td>
                <td>${loc.latitude}</td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>