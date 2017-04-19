
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>
        <form action="./Challenge01.jsp" method="post">
            名前：<input type="text" name="txtName"> &nbsp;
            男性：<input type="radio" name="sex" value="1">
            女性：<input type="radio" name="sex" value="2"> &nbsp;
            趣味：<textarea name="mulText"></textarea>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
    </body>
</html>
