<%@page import="java.time.Year"%>
<%@page import="java.util.Calendar"%>
<%@page import="jums.JumsHelper" 
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <!-- 修正 初期値 -->
        <input type="text" name="name" value="<%= udd.getName() %>">
        <br><br>
        生年月日:　
        <!-- 修正 初期値設定, 生年月日をcalendar型に変換して計算 -->
        <% 
            Calendar calBirth = Calendar.getInstance();
            calBirth.setTime(udd.getBirthday());
        %>
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2017; i++){ %>
            <option value="<%=i%>" <% if(calBirth.get(Calendar.YEAR)==i){out.print("selected = \"selected\"");}%> ><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(calBirth.get(Calendar.MONTH)+1==i){out.print("selected = \"selected\"");}%> ><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<% if(calBirth.get(Calendar.DATE)==i){out.print("selected = \"selected\"");}%> ><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <!-- 修正 初期値 -->
            <input type="radio" name="type" value="<%=i%>" <%if(udd.getType() == i){out.print("checked = \"checked\"");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <!-- 修正 初期値 -->
        <input type="text" name="tell" value="<%= udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <!-- 修正 初期値 -->
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment() %></textarea><br><br>
        
        <!-- 修正 userIDを渡す -->
        <input type="hidden" name="id"  value="<%= udd.getUserID() %>">
        <input type="submit" name="btnSubmit" value="送信">
    </form>
    <!-- 詳細画面へ戻るボタン。IDを渡す -->
    <form action="ResultDetail" method="POST">
        <input type="submit" name="back" value="詳細画面へ戻る"style="width:100px">
        <!-- 詳細情報のuserIDを渡すように変更 -->
        <input type="hidden" name="id"  value="<%= udd.getUserID() %>">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
