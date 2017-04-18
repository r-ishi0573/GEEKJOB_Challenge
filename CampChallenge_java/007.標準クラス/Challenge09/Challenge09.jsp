
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*, java.text.*, java.io.*"%>
<!DOCTYPE html>

<%
    File txt = new File(application.getRealPath("text.txt"));
    
    FileReader fr = new FileReader(txt);
    BufferedReader br = new BufferedReader(fr);
    String str;
    
    while( (str = br.readLine()) != null ) {
        out.print(str);
        out.print("<br>");
    }
    
    br.close();
%>