
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*, java.text.*, java.io.*,java.lang.Math"%>
<!DOCTYPE html>

<%
    /*
      使用した標準クラス：java.lang.Math
      二次方程式(ax^2+bx+c=0)の解を求める。
      ただし、b^2-4ac<0の場合はサポートしない。
    */

    Calendar cal = Calendar.getInstance();
    
    File txt = new File("/Users/Alice/NetBeansProjects/DefaultClass/web/text.txt");
    
    FileReader fr = new FileReader(txt);
    BufferedReader br = new BufferedReader(fr);
    String str;
    
    FileWriter fw = new FileWriter(txt);
    BufferedWriter bw = new BufferedWriter(fw);
    
    final Double a = 2.0;
    final Double b = 3.0;
    final Double c = -2.0;
    double x1 = 0.0, x2 = 0.0;
    Double cond = 0.0; //条件式
    
    bw.write("\n"+cal.getInstance().getTime()+"　タイトルの表示　開始\n");
    out.print("***二次方程式解法プログラム***<br>");
    bw.write("\n"+cal.getInstance().getTime()+"　タイトルの表示　終了\n");
    
    bw.write("\n"+cal.getInstance().getTime()+"　パラメータの表示　開始\n");
    out.print("a="+ a +", b="+ b +", c="+ c +"<br>");
    bw.write("\n"+cal.getInstance().getTime()+"　パラメータの表示　終了\n");
    
    bw.write("\n"+cal.getInstance().getTime()+"　条件式の計算　開始\n");
    cond = b*b - 4*a*c; //条件式計算
    bw.write("\n"+cal.getInstance().getTime()+"　条件式の計算　終了\n");
    out.print("条件式："+cond+"<br>");
    
    bw.write("\n"+cal.getInstance().getTime()+"　スリープの開始　開始\n");
    Thread.sleep(3000); //タイムスタンプ用にちょっと待つ
    bw.write("\n"+cal.getInstance().getTime()+"　スリープの終了　終了\n");
    
    /*
      解の計算、書き込み
    */
    //条件式の判定
    bw.write("\n"+cal.getInstance().getTime()+"　条件式の判定　開始\n");
    if(cond  >= 0) {
        bw.write("\n"+cal.getInstance().getTime()+"　x1の計算　開始\n");
        x1 = (-1.0*b + Math.sqrt(cond)) / (2.0*a);
        bw.write("\n"+cal.getInstance().getTime()+"　x1の計算　終了\n");
        
        bw.write("\n"+cal.getInstance().getTime()+"　x2の計算　開始\n");
        x2 = (-1.0*b - Math.sqrt(cond)) / (2.0*a);
        bw.write("\n"+cal.getInstance().getTime()+"　x2の計算　終了\n");

        out.print("解：x=("+x1+","+x2+")<br>");
    }
    else {
        bw.write("\n"+cal.getInstance().getTime()+"　条件式<0の場合のエラー表示　開始\n");
        out.print("エラー：b^2-4ac<0です。<br>");
        bw.write("\n"+cal.getInstance().getTime()+"　条件式<0の場合のエラー表示　終了\n");
    }
    bw.write("\n"+cal.getInstance().getTime()+"　条件式の判定　終了\n");

    bw.close();
    
    /*
      書き込み結果表示
    */
    out.print("<br>***ログ表示***");
    while( (str = br.readLine()) != null ) {
        out.print(str);
        out.print("<br>");
    }
    
    br.close();
%>