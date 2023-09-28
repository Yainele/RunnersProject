
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>

<div class="content-wrapper">
    <%@ include file="header.jsp" %>
    <main>
        <div class="wrapper">
            <div class="wrapper parallax">

            </div>
            <section class="model">
                <div class="what_is">
                    <div class="card">
                        <div class="card-content">
                            <h2>Что это?</h2>
                            <p> description</p>
                            <a href="#">Read More</a>
                        </div>
                        <div class="card-content">
                            <img src="../../resources/css/runner.png" alt="">
                        </div>
                    </div>
                </div>
                <div class="sign_up">
                    <div class="card_sign_up">
                        <div class="card-content">
                            <h2>Принять участие</h2>
                            <p> description</p>
                            <a href="#">Read More</a>
                        </div>
                    </div>
                    <div class="card_sign_up">
                        <div class="card-content">
                            <h2>Выбрать дату</h2>
                            <p> description</p>
                            <a href="#">Read More</a>
                        </div>
                    </div>
                    <div class="card_sign_up">
                        <div class="card-content">
                            <h2>Группа поддержки</h2>
                            <p> description</p>
                            <a href="#">Read More</a>
                        </div>
                    </div>

                </div>
                <div class="tournament">
                    <div class="card_tour">
                        <div class="card-content">
                            <p style="font-size: 20px; margin: 0; padding: 10px 1em">Таблица лидеров</p>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Nick</th>
                                    <th>Birthday</th>
                                    <th>Time</th>
                                    <th>Long</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>

                                    <td>Илья</td>
                                    <td>Тепляков</td>
                                    <td>seriousnuts</td>
                                    <td>16/02/2000</td>
                                    <td>999 часов</td>
                                    <td>2 км</td>
                                </tr>
                                <tr>
                                    <td>Евгения</td>
                                    <td>Семенова</td>
                                    <td>prokanaktis</td>
                                    <td>28/07/2000</td>
                                    <td>999 часов</td>
                                    <td>1 км</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>

                </div>

            </section>
            <footer class="footer">
                <p style="font-size: 12px; margin: 0; padding: 10px 1em;">iliya LTD.</p>
            </footer>
        </div>
    </main>
</div>
</body>
</html>