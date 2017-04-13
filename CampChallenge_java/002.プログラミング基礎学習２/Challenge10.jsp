<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%
    int num = Integer.parseInt(request.getParameter("param1")); 
    //int num = 4620;
    int prime[] = {2, 3, 5, 7};
    
    out.println(num);
    
    for(int val : prime) {
        while( (num % val) == 0) {
            num = num / val;
            out.println(val);
        }
    }
    
    //1桁の素数で素因数分解した結果が1でない(=2桁の素数が含まれる)
    if(num != 1) out.println("その他");

%>
