<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="../../resources/css/registration.css">
</head>

<body>
<div class="content-wrapper">
    <header class="header">
        <p style="font-size: 30px; margin: 0; padding: 10px 1em;">100km</p>
    </header>
    <main>
    <div class="wrapper">
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
                <div class="sign_button">
                    <button type="submit">Зарегистрироваться</button>
                </div>
                </form:form>
            </div>
        </div>
    </div>
    <a href="/">Главная</a>
    </main>
</div>
<footer class="footer">
    <p style="font-size: 12px; margin: 0; padding: 10px 1em;">iliya LTD.</p>
</footer>
</body>
</html>




