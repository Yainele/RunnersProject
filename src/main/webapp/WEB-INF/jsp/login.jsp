<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="../../resources/css/registration.css">
</head>

<body>
<div class="content-wrapper">
    <header class="header">
        <p style="font-size: 30px; margin: 0; padding: 10px 1em;">100km</p>
    </header>
    <main>
        <div class="wrapper">
            <section class="model">
                <div class="sign_in">
                    <sec:authorize access="isAuthenticated()">
                        <% response.sendRedirect("news"); %>
                    </sec:authorize>
                    <div class="card">
                        <form method="POST" action="/login">
                            <div class="card-content">
                                <h2>Вход</h2>
                                <div class=username>
                                    <input name="username" type="text" placeholder="Username"
                                           autofocus="true"/>
                                </div>
                                <div class="password">
                                    <input name="password" type="password" placeholder="Password"/>
                                </div>
                                <div class="sign_in">
                                    <button class="floating-button" type="submit">Войти</button>
                                </div>
                                <div class="register_button">
                                <h4><a class="floating-button" href="/registration">Зарегистрироваться</a></h4>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </main>
    <footer class="footer">
        <p style="font-size: 12px; margin: 0; padding: 10px 1em;">iliya LTD.</p>
    </footer>
</div>
</body>
</html>
