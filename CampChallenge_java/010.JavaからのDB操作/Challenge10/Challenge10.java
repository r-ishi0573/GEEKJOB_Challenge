package org.camp.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Challenge10 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //文字コード、出力設定
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //入力を取得
        int in_profilesID = Integer.parseInt( request.getParameter("profilesID") );

        //DB用の変数の初期化
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try {
            //データベース接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","user","user");
            
            //DBのデータを削除
            db_st = db_con.prepareStatement("delete from profiles where profilesID=?");
            db_st.setInt(1, in_profilesID);
            
            db_st.executeUpdate(); //更新
            
            //DBからデータを取得
            db_st = db_con.prepareStatement("select * from profiles");
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
