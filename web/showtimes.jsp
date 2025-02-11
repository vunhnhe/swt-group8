<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Showtime" %>

<%
    List<Showtime> showtimes = (List<Showtime>) request.getAttribute("showtimes");
    if (showtimes == null) {
        showtimes = new java.util.ArrayList<>();
    }
%>

<option value="">Select Start Time</option>
<% for (Showtime st : showtimes) { %>
    <option value="<%= st.getStartTime() %>" data-endtime="<%= st.getEndTime() %>"><%= st.getStartTime() %></option>
<% } %>