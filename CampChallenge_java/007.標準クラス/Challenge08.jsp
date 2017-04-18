
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*, java.text.*, java.io.*"%>
<!DOCTYPE html>

<%
    File txt = new File(application.getRealPath("text.txt"));
    
    FileWriter fw = new FileWriter(txt);
    BufferedWriter bw = new BufferedWriter(fw);
    fw.write("名前：石川龍斗");
    bw.newLine();
    bw.write("年齢：29歳");
    bw.newLine();
    bw.close();
    
    FileReader fr = new FileReader(txt);
    BufferedReader br = new BufferedReader(fr);
    String str;
    
    while( (str = br.readLine()) != null ) {
        out.print(str);
        out.print("<br>");
    }
    
    br.close();
%>