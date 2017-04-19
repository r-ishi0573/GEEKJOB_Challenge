
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge02</title>
    </head>
    <body>
        <form action="./Challenge02.jsp" method="post">
            名前：<input type="text" name="name"> &nbsp;
            男性：<input type="radio" name="sex" value="1">
            女性：<input type="radio" name="sex" value="2"> &nbsp;
            趣味：<textarea name="hobby"></textarea>
            <input type="submit" name="btnSubmit" value="送信">
        </form>
    </body>
    </body>
</html>

<%
    request.setCharacterEncoding("UTF-8");
    
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String hobby = request.getParameter("hobby");
    
    //テキストボックスから名前を取得して表示
    if(name != "") {
        out.print("名前："+ name);
        out.print("<br>");
    }
    
    //ラジオボタンから値(男性：1, 女性：2)を取得し、性別の判定と表示
    if(sex != null) {
        out.print("性別：");
        if(sex.equals("1")) {
            out.print("男性");
        }
        else {
            out.print("女性");
        }
        out.print("<br>");
    }
    
    //複数行テキストボックスから趣味を取得
    if(hobby != "") {
        out.print("趣味："+ hobby);
        out.print("<br>");
    }

%>
