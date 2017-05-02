<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.sql.ResultSet" 
        import="java.util.ArrayList" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
    //ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)request.getAttribute("resultData");
    //修正 セッションから受け取るよう変更
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)hs.getAttribute("resultData"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <!--
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
                
                <td><a href="ResultDetail?id=<//%= udd.getUserID()%>"><//%= udd.getName()%></a></td>
                <td><//%= udd.getBirthday()%></td>
                <td><//%= udd.getType()%></td>
                <td><//%= udd.getNewDate()%></td>
                
            </tr>
            -->
            <!-- DTOの配列をfor-eachで表示する動作に変更。Hitしない場合(要素なし)のチェックあり -->
            <% if(udd.size() == 0) out.print("該当なし"); %>
            <% for (UserDataDTO val : udd) { %>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
                
                <td><a href="ResultDetail?id=<%= val.getUserID()%>"><%= val.getName()%></a></td>
                <td><%= val.getBirthday()%></td>
                <td><%= val.getType()%></td>
                <td><%= val.getNewDate()%></td>
                
            </tr>
            <% } %>
            <!-- 表示ここまで -->
        </table>
    </body>
    <%=jh.home()%>
</html>
