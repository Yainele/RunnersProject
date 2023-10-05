<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="../../resources/css/registration.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div class="content-wrapper">
    <%@ include file="header.jsp" %>
    <main>
        <div class="wrapper">
            <section class="model">
                <div class="sign_up">
                    <form:form method="POST" modelAttribute="DefiniteLocation" action="/creat_location/add_location">
                    <div class="card">
                        <div class="card-content">
                            <h2>Создать локацию</h2>
                            <div class="locationName entry_field">
                                <form:input type="text" path="locationName" placeholder="Название локации"
                                            autofocus="true"></form:input>
                                <form:errors path="locationName"></form:errors>
                                    ${locationNameError}
                            </div>
                            <div class="locationDescription entry_field">
                                <form:input type="text" path="locationDescription" placeholder="описание локации"></form:input>
                            </div>
                            <div class="longitude entry_field">
                                <form:input type="number" path="longitude" placeholder="долгота"></form:input>
                            </div><div class="locationDescription entry_field">
                                <form:input type="number" path="latitude" placeholder="широта"></form:input>
                            </div>
                            <div class="regitstration_button">
                                <button class="floating-button" type="submit">Добавить локацию</button>
                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>