<%@page import="java.util.Calendar"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)request.getAttribute("udd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <% 
            Calendar calBirth = Calendar.getInstance();
            calBirth.setTime(udd.getBirthday());
    %>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= calBirth.get(Calendar.YEAR)+"年"
                +(calBirth.get(Calendar.MONTH)+1)+"月"
                +calBirth.get(Calendar.DATE)+"日"%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        以上の内容で登録しました。<br>
        <!-- 詳細画面へ戻るボタン。IDを渡す -->
    <form action="ResultDetail" method="POST">
        <input type="submit" name="back" value="詳細画面へ戻る"style="width:100px">
        <!-- 詳細情報のuserIDを渡すように変更 -->
        <input type="hidden" name="id"  value="<%= udd.getUserID() %>">
    </form>
    </body>
    <%=jh.home()%>
    </body>
</html>
