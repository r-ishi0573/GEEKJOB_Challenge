<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*, javax.servlet.http.Cookie" %>

<%
    request.setCharacterEncoding("UTF-8");
    
    Date now = new Date();
    out.print("現在時刻：" + now + "<br><br>");
    
    Cookie cs[] = request.getCookies();
    if(cs != null) {
        for(int i=0; i<cs.length; i++) {
            if(cs[i].getName().equals("LastLogin")) {
                out.print("最後のログインは、"+ cs[i].getValue());
                out.print("<br>");
                break;
            }
        }
    }
    
    Date time = new Date();
    Cookie c = new Cookie("LastLogin", time.toString());

    response.addCookie(c);
    
%> 

