<!--
   課題7のソース修正提出
    データベース挿入、登録結果の確認が終了したため、
    不要になったJavaDataBeansのセッションを破棄するよう変更
    (42行目)
-->

<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <!--
        <h1>登録結果</h1><br>
        名前:%= hs.getAttribute("name")%><br>
        生年月日:%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:%= hs.getAttribute("type")%><br>
        電話番号:%= hs.getAttribute("tell")%><br>
        自己紹介:%= hs.getAttribute("comment")%><br>
        以上の内容で登録しました。<br>
        <br>
        -->
        <h1>登録結果</h1><br>
        名前:<%= udb.getName() %><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType() %><br>
        電話番号:<%= udb.getTell() %><br>
        自己紹介:<%= udb.getComment() %><br>
        以上の内容で登録しました。<br>
        
    <!-- 課題7のソース修正 -->
        <% hs.removeAttribute("UDB"); %>
    <!-- 課題7のソース修正ここまで -->
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
