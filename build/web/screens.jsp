<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Screen" %>

<%
    List<Screen> screens = (List<Screen>) request.getAttribute("screens");
    if (screens == null) {
        screens = new java.util.ArrayList<>();
    }
%>

<option value="">Select Screen</option>
<% for (Screen screen : screens) { %>
    <option value="<%= screen.getScreenID() %>"><%= screen.getScreenName() %></option>
<% } %>