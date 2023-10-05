<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/event"); %>
</sec:authorize>