<!--
    課題5のソース修正提出
    Beansに値が入っていればそれを初期値としてフォームに入力するよう変更
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
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <!-- <input type="text" name="name" value=""> -->
        <!-- 課題5 -->
        <input type="text" name="name" value="<%= udb.getName() %>">
        <br><br>

        生年月日:　
        <select name="year">
            <!-- 課題5 -->
            <!-- Beansに値が入っている場合、初期値を設定 -->
            <% if(!udb.getYear().equals("")) { %><option value="<%= udb.getYear() %>">
                <%= udb.getYear() %></option> <% } %>
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <!-- Beansに値が入っている場合、初期値を設定 -->
            <% if(!udb.getMonth().equals("")) { %><option value="<%= udb.getMonth() %>">
                <%= udb.getMonth() %></option> <% } %>
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <!-- Beansに値が入っている場合、初期値を設定 -->
            <% if(!udb.getDay().equals("")) { %><option value="<%= udb.getDay() %>">
                <%= udb.getDay() %></option> <% } %>
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <% int i;
           try {
            i = Integer.parseInt((String)udb.getType());
           } catch(NumberFormatException e) {
                i = 0;
           }
        %>
        <!--
        <input type="radio" name="type" value="1" checked>エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        -->
        <!-- 課題5 -->
        <input type="radio" name="type" value="1" <%= i==1 ? "checked=\"checked\"" : "" %> >エンジニア<br>
        <input type="radio" name="type" value="2" <%= i==2 ? "checked=\"checked\"" : "" %> >営業<br>
        <input type="radio" name="type" value="3" <%= i==3 ? "checked=\"checked\"" : "" %> >その他<br>
        <!-- 課題5ここまで -->
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udb.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udb.getComment() %></textarea><br><br>
                <form action="insertresult" method="POST">
        <!--<input type="hidden" name="ac"  value="<//%=hs.getAttribute("ac") %>">-->
        <input type="hidden" name="ac"  value="<%= udb.getIsAccess() %>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
