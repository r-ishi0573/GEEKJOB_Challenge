<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //クエリストリングから値を取得して変数に保存
    int sougaku = Integer.parseInt(request.getParameter("param1"));
    int kosuu = Integer.parseInt(request.getParameter("param2"));
    int shubetsu = Integer.parseInt(request.getParameter("param3"));
    
    //商品種別の表示
    out.print("商品種別：");
    if(shubetsu == 1) {
     out.print("雑貨<br>");       
    }
    else if(shubetsu == 2) {
        out.println("生鮮食品<br>");
    }
    else {
        out.println("その他<br>");
    }
    
    //総額と個数の表示
    out.print("総額："+sougaku+"円　1個あたりの値段："+(sougaku/kosuu)+"円<br>");
    
    //ポイントの表示
    if(sougaku >= 5000) {
        out.print("ポイント："+(sougaku*0.05)+"<br>");
    }
    else if(sougaku >= 3000) {
        out.print("ポイント："+(sougaku*0.04)+"<br>");
    }
    else {
        
    }

%>
