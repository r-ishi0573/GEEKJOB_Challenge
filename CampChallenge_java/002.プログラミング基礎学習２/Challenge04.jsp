<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%
    String st = "";
    //ArrayList<String> al = new ArrayList<String>();
    
    for(int i=0; i<30; i++) {
        st = st + "A";
    }
    
    out.print(st);

%>
