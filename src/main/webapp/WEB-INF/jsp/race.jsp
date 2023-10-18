<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log in with your account</title>
    <link rel="stylesheet" href="../../resources/css/race.css">
</head>

<body>
<div class="content-wrapper">
    <%@ include file="header.jsp" %>
    <main>
            <div class="card">
                <div class="card-content">
                    <H3> Забег совершит - ${userForRace_form_object.getUsername()}</H3>
                    <H4> Время забега - ${race_form_object.getUserStartTime()}</H4>
                    <H4> статус забега - ${race_form_object.getRaceStatus()}</H4>
                    <H4> локация - ${locationForRace_form_object.getLocationName()}</h4>

                </div>
            </div>
        <div class="wrapper">
        </div>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
