<!--
   課題4のソース修正提出
    修正箇所
    ・入力情報のチェックで"名前"のみ値を確認していた　⇨　他の入力情報"すべて"を確認するに変更
      (26行〜29行)
    ・上記入力チェックでエラーがあった場合にどの入力が不正か再度チェックし、
      不正であった項目名を表示(44行〜49行)
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
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <!-- 課題4の修正 -->
    <% if(!udb.getName().equals("") && !udb.getYear().equals("") 
            && !udb.getMonth().equals("") && !udb.getDay().equals("")
            && !(udb.getType() == null) && !udb.getTell().equals("") 
            && !udb.getComment().equals("")){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName() %><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <!--<input type="hidden" name="ac"  value="<//%= hs.getAttribute("ac")%>">-->
            <input type="hidden" name="ac"  value="<%= udb.getIsAccess() %>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>以下の入力が不完全です</h1>
        <% if(udb.getName().equals("")) { %> 名前<br> <% } %>
        <% if(udb.getYear().equals("") || udb.getMonth().equals("")
                || udb.getDay().equals("")) { %> 生年月日<br> <% } %>
                <% if(udb.getType() == null) { %> 種別<br> <% } %>
                <% if(udb.getTell().equals("")) { %> 電話番号<br> <% } %>
                <% if(udb.getComment().equals("")) { %> 自己紹介<br> <% } %>
    <% } %>
    <!-- 課題4の修正ここまで -->
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
