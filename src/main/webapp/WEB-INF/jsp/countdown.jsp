<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Обратный отсчет</title>
    <style>
        .countdown-wrapper {
            background-color: #f8f8f8;
            border: 2px solid #ddd;
            border-radius: 10px;
            padding: 50px;
            max-width: 300px;
            margin: 0 auto;
            text-align: center;
        }

        .countdown {
            font-size: 15px;
            font-weight: bold;
            color: #333;
        }

        .countdown-label {
            font-size: 18px;
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
                    document.getElementById('countdown').innerHTML = data;
                    setTimeout(updateCountdown, 500);
                });
        }

        updateCountdown();
    </script>
</body>
</html>
