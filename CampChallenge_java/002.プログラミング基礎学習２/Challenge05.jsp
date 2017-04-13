<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 0;
    
    for(int i=0; i<=100; i++) {
        num = num + i;
    }
    
    out.print(num);

%>
