<!--
　　「課題：入力フィールドの作成と実装」の入力フォームを
     <table>タグを使って表示を整形しています。
-->

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, javax.servlet.http.Cookie" %>

<%
    request.setCharacterEncoding("UTF-8");
    /*
      クッキーからデータを取得
     */
    Cookie cs[] = request.getCookies();
    //HTML出力用の変数
    String def_name = ""; //名前
    boolean def_sex = true; //性別
    String def_hobby = ""; //趣味
    
    //取得開始
    if (cs != null) {
        for (int i = 0; i < cs.length; i++) {
            //名前の取得
            if (cs[i].getName().equals("name")) {
                out.print("名前：");
                out.print(URLDecoder.decode(cs[i].getValue(), "UTF-8"));
                out.print("<br>");
                def_name = URLDecoder.decode(cs[i].getValue(), "UTF-8");
            }
            //性別の取得
            if (cs[i].getName().equals("sex")) {
                out.print("性別：");
                //男性ボタンが押されていた場合
                if (cs[i].getValue().equals("1")) {
                    out.print("男性");
                    def_sex = true;
                } else { //女性ボタン
                    out.print("女性");
                    def_sex = false;
                }
                out.print("<br>");
            }
            //趣味の取得
            if (cs[i].getName().equals("hobby")) {
                out.print("趣味：");
                out.print(URLDecoder.decode(cs[i].getValue(), "UTF-8"));
                out.print("<br>");
                def_hobby = URLDecoder.decode(cs[i].getValue(), "UTF-8");
            }
        }
    }
    //取得終了
    out.print("<br>");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge06</title>
    </head>
    <body>
        <b>・項目を入力してください。</b>
        <form action="./Challenge06.jsp" method="post">
            <table>
                <tr>
                    <td>名前：</td>
                    <td><input type="text" name="name" value="<%= def_name%>"> &nbsp;</td>
                    <td>男性：</td>
                    <td><input type="radio" name="sex" value="1" <%= def_sex ? "checked=checked" : ""%>> &ensp;</td>
                    <td>女性：</td>
                    <td><input type="radio" name="sex" value="2" <%= def_sex ? "" : "checked=checked"%>></td>
                </tr>
                <tr>
                    <td>趣味：</td>
                    <td><textarea name="hobby"><%= def_hobby%></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnSubmit" value="送信"></td>
                </tr>
            </table>
        </form>
    </body>
</body>
</html>
<%
    /*
     [入力を保持する変数]
     num_item:アイテムの個数,
     item[]:入力を受け取る項目(0:名前,1:性別,2:趣味)
     */
    final int num_item = 3;
    String[] item = new String[num_item];

    //ブラウザから入力を取得
    item[0] = request.getParameter("name");
    item[1] = request.getParameter("sex");
    item[2] = request.getParameter("hobby");
    
    //入力をクッキーへ出力する
    Cookie c;
    if(item[0] != null) {
    c = new Cookie("name", URLEncoder.encode(item[0], "UTF-8"));
    response.addCookie(c);
    }
    if(item[1] != null) {
    c = new Cookie("sex", URLEncoder.encode(item[1], "UTF-8"));
    response.addCookie(c);
    }
    if(item[2] != null) {
    c = new Cookie("hobby", URLEncoder.encode(item[2], "UTF-8"));
    response.addCookie(c);
    }

%>
