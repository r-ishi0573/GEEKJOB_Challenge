package org.camp.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Challenge12 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        /*
          入力を取得
        */
        String in_name = request.getParameter("name");
        String in_AND_OR1 = request.getParameter("AND_OR1"); //AND/OR検索判定用その1
        //年齢入力。入力が数字かどうか判定(入力が、数字:入力された値 未入力:0 数字以外:-1)
        int in_age;
        try {
            in_age = Integer.parseInt( request.getParameter("age") );
        } catch (NumberFormatException nfex) {
            if(request.getParameter("age") == "") { //未入力の場合
                in_age = 0;
            } else { //入力が数字以外の場合
		in_age = -1;
            }
	}
        String in_AND_OR2 = request.getParameter("AND_OR2"); //AND/OR検索判定用その2
        String in_birthday = request.getParameter("birthday");

        //DB用の変数の初期化
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            //データベース接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","user","user");
            
            /*
              DBからデータを検索する処理
              --入力によってSQL文を変更
            */
            String sql = "select * from profiles";
            
            //どれか１つでも入力がある場合、where句追加
            if(in_name != "" || in_age != 0 || in_birthday != "") {
                sql = sql + " where";
            }
            
            //名前入力の判定
            if(in_name != "") { 
                sql = sql + " name like '%"+ in_name + "%'";
                //さらに入力がある場合、AND/OR追加
                if( in_age != 0 || in_birthday != "" ) {
                    sql = sql + " " + in_AND_OR1;
                }
            }
            
            //年齢入力の判定
            if(in_age != 0) {
                sql = sql + " age = "+ in_age;
                //さらに入力がある場合、AND/OR追加
                if(in_birthday != "") {
                    sql = sql + " " + in_AND_OR2;
                }
            }
            
            //生年月日入力の判定
            if(in_birthday != "") {
                sql = sql + " birthday = "+ in_birthday;
            }
            
            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();
            
            //DBから取得したデータを表示
            while(db_data.next()) {
                int profilesID = db_data.getInt("profilesID");
                String name = db_data.getString("name");
                String tell = db_data.getString("tell");
                int age = db_data.getInt("age");
                String birthday = db_data.getString("birthday");
                
                out.print(profilesID+" "+name+" "+tell+" "+age+" "+" "+birthday);
                out.print("<br>");
            }
            
            //クローズ処理
            db_data.close();
            db_st.close();
            db_con.close();
            
        } catch(SQLException e_sql) {
            out.print("1.接続時にエラーが発生しました："+e_sql.toString());
        } catch(Exception e) {
            out.print("2.接続時にエラーが発生しました："+e.toString());
        } finally {
            if(db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
