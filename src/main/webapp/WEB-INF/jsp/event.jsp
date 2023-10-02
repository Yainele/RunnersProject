<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Event</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/event.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<%@ include file="header.jsp" %>
<div class="content-wrapper">
    <c:forEach items="${allDefiniteLocations}" var="loc">
    <div class="card">
        <div class="card-content">
            <h3>${loc.getLocationName()}</h3>
            <p>${loc.getLocationDescription()}</p>
            <a href=" https://yandex.ru/maps/?pt=${loc.getLongitude()},${loc.getLatitude()}z=18&l=map" target="_blank">Посмотреть точку старта локации</a>
        </div>
        <input type="radio" id="radioButton" />
        <label for="radioButton"></label>
    </div>
        </c:forEach>
    <div class="card">
        <div class="card-content">
            <a href="/create_location">Создать собственную локацию</a>
        </div>
        <input type="radio" id="own_location"/>
        <label for="radioButton"></label>
    </div>
    <a href="/">Главная</a>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>