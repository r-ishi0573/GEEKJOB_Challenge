<!--
    課題7のソース修正提出
    トップページを踏んだ場合にUserDataBeansのセッションが削除されるように変更
    (他ページからトップページへ戻った場合。
     途中でウインドウを閉じたあとに再度このページを開いた場合を想定)
    (10行〜15行目)
-->

<!-- 課題7のソース修正 -->
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    if((UserDataBeans)hs.getAttribute("UDB") != null) hs.removeAttribute("UDB");
%>
<!-- 課題7のソース修正ここまで -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JUMSトップ</title>
</head>
<body>
    <h1>ユーザー情報管理トップ</h1><br>
    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
    <a href="insert">新規登録</a><br>
    <a href="" >検索(修正・削除)</a><br>
</body>
</html>
