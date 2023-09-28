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
                    <form:form method="POST" modelAttribute="userForm">
                    <div class="card">
                        <div class="card-content">
                            <h2>Регистрация</h2>
                            <div class="username entry_field">
                                <form:input type="text" path="username" placeholder="Username"
                                            autofocus="true"></form:input>
                                <form:errors path="username"></form:errors>
                                    ${usernameError}
                            </div>
                            <div class="password entry_field">
                                <form:input type="password" path="password" placeholder="Password"></form:input>
                            </div>
                            <div class="password_retype entry_field">
                                <form:input type="password" path="passwordConfirm"
                                            placeholder="Confirm your password"></form:input>
                                <form:errors path="password"></form:errors>
                                    ${passwordError}
                            </div>
                            <div class="regitstration_button">
                                <button class="floating-button" type="submit">Зарегистрироваться</button>
                            </div>
                            </form:form>
                            <h4><a class="floating-button" href="/login">Войти</a></h4>
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




