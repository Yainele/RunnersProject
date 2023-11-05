<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Обратный отсчет</title>
    <style>
        .countdown-wrapper {
            background-color: rgb(255, 255, 255);
            border: 2px solid #ddd;
            height: 250px;
            border-radius: 10px;
            max-width: 300px;
        }

        .countdown {
            font-size: 14px;
            font-weight: bold;
            color: #333;
            padding-top: 30px;
        }

        .countdown-label {
            font-size: 15px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="countdown-wrapper">
        <H3 class="countdown-label">Обратный отсчет до начала забега</H3>
        <div id="countdown" class="countdown"></div>
    </div>

    <script>
       function updateCountdown() {
           fetch('/countdown')
               .then(response => response.text())
               .then(data => {
                   let countdownElement = document.getElementById('countdown');
                   countdownElement.innerHTML = data;

                   if (data === '0 дней, 0 часов, 0 минут, 0 секунд') {
                       clearTimeout(countdownTimer);
                   } else {
                       setTimeout(updateCountdown, 500);
                   }
               });
       }

       let countdownTimer = setTimeout(updateCountdown, 500);
    </script>
</body>
</html>
