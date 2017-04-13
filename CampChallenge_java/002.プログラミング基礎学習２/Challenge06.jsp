<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 1000;
    
    while(num >= 100) {
        num = num / 2;
    }
    
    out.print(num);

%>
