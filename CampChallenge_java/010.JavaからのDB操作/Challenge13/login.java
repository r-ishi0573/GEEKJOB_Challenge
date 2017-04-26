/*
  ::ログイン操作を行うサーブレット::
  1.login.htmlからユーザ名、パスワードを受け取り、[テーブル:login]のデータと照合し、
     OK → item.jspへ遷移
     NG → loginMiss.htmlへ遷移
*/

package org.camp.chl13;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //ユーザネーム、パスワード入力
        String in_userName = request.getParameter("userName");
        String in_password = request.getParameter("password");
        
        //ログイン判定用変数(成功:true 失敗:false)
        boolean loginFlag = false;
        
        //データベース用変数の初期化
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        //データベース接続
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","user","user");
            
            //Tableの要素を取得
            db_st = db_con.prepareStatement("select * from login");
            db_data = db_st.executeQuery();
            
            //ログイン判定処理
            while(db_data.next()) {
                //テーブルからユーザ、パス取得
                String userName = db_data.getString("userName");
                String password = db_data.getString("password");
                
                //ログイン判定(フォームからの入力 == データベースの値)
                if(in_userName.equals(userName) && 
                        in_password.equals(password)) {
                    //一致する行が存在した場合
                    loginFlag = true;
                    //break;
                }

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
        
        /*
          ログイン判定後のページ遷移の処理
        */
        RequestDispatcher rd;

        if(loginFlag) { //ログイン成功
            //商品管理ページへ
            rd = request.getRequestDispatcher("/WEB-INF/item.jsp");
        } else { //ログイン失敗
            //ログイン失敗ページへ
            rd = request.getRequestDispatcher("/WEB-INF/loginMiss.html");
        }
        
        rd.forward(request, response);
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
