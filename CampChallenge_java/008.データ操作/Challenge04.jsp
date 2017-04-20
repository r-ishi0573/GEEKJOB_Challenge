<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="javax.servlet.http.HttpSession" %>

<%
    request.setCharacterEncoding("UTF-8");
    
    Date now = new Date();
    out.print("現在時刻：" + now + "<br><br>");
    
    HttpSession hs = request.getSession(true);
    if(hs.getAttribute("LastLogin") != null) {
        out.print("最後のログインは、"+ hs.getAttribute("LastLogin"));
    }

    Date time = new Date();
    hs.setAttribute("LastLogin", time.toString());
    
%> 