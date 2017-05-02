<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <!-- 検索結果に戻る画面追加 -->
    <a href="searchresult.jsp">検索結果に戻る</a>
    <br>
    <%=jh.home()%>
    </body>
</html>
