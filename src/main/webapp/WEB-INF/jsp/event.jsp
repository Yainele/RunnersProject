<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
%>

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
    <form method="POST" modelAttribute="race_form" action="/create_race">
    <div class="pick-location">
    <c:forEach items="${allDefiniteLocations}" var="loc">
    <div class="card">
        <div class="card-content">
            <h3>${loc.getLocationName()}</h3>
            <p>${loc.getLocationDescription()}</p>
            <a href=" https://yandex.ru/maps/?pt=${loc.getLongitude()},${loc.getLatitude()}z=18&l=map" target="_blank">Посмотреть точку старта локации</a>
        </div>
        <input type="radio" id="radioButton" name="locationId" value=${loc.getLocationId()} />
        <label for="radioButton"></label>
    </div>
        </c:forEach>
    <div class="card">
        <div class="card-content">
            <a href="/creat_location">Создать собственную локацию</a>
        </div>
    </div>
        <div class="pick-time">
            <label for="localdate">Дата и время: </label>
            <input type="datetime-local" id="localdate" name="userStartTime"/>
        </div>
    </div>
    <div class="create-event">
        <button class="floating-button" type="submit">создать забег</button>
    </div>
    </form:form>
    <a href="/">Главная</a>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>