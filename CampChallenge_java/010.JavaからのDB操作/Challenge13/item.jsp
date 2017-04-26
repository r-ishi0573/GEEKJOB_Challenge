<!--
     ::商品登録ページ::
     1.商品情報を入力し、送信ボタンを押すとDBにデータ登録
     2.一覧表示のボタンを押すとDBに登録されたデータを表示
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.camp.chl13.ItemError, org.camp.chl13.showItem" %>
<!DOCTYPE html>

<html>
    <head>
        <%  //Item.javaからエラーを受け取る
            ItemError ie = (ItemError) request.getAttribute("IE");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品管理</title>
    </head>
    <body>
        <p>商品追加</p>
        <form action="Item" method="post">
            商品名：<input type="text" name="itemName">
            <%  //入力エラーを表示
                if(ie != null) {
                    out.print(ie.getINE());
                }
            %>
            <br>
            価格：<input type="text" name="price">
            <%  //入力エラーを表示
                if(ie != null) {
                    out.print(ie.getPE());
                }
            %>
            <br>
            <input type="submit" name="btnSubmit" value="送信">
        </form>
        <form action="showItem" method="post">
            <input type="submit" name="btnSubmit" value="一覧表示">
        </form>
    </body>
</html>