<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    char item = 'A';
    String message = "";
    
    switch(item) {
        case 'A':
            message = "英語";
            break;
        case 'あ':
            message = "日本語";
            break;
        default:
            break;
    }
    
    if(message != null) out.print(message);

%>

