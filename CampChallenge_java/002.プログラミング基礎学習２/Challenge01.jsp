<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 0;
    String message = "";
    
    switch(num) {
        case 1:
            message = "one";
            break;
        case 2:
            message = "two";
            break;
        default:
            message = "想定外";
        break;
    }
    
    out.print(message);

%>

