/*
  商品登録ページで入力を受け取り、[テーブル:item]へデータを追加するサーブレット
  [入力チェックの動作]
   1.入力エラー → 2.itemError.javaへ値をセット → 3.item.jspへ遷移
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
import org.camp.chl13.ItemError;

public class Item extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //文字コード設定
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        /*
          商品名、価格の入力を受け取る
         */
        //商品名を受け取る
        String in_itemName = request.getParameter("itemName");

        //価格を受け取る。数値チェックを行い、値が不正な場合は値を無効(-1)な値にする
        int in_price;
        try {
            in_price = Integer.parseInt(request.getParameter("price"));
        } catch (NumberFormatException nfex) {
            in_price = -1;
        }

        /*
          入力が無効でないかチェックし、入力が無効だった場合エラーページへ遷移
         */
        //入力NGの場合
        if (in_itemName.equals("") || (in_price <= -1)) {
            ItemError ie = new ItemError();

            //エラーメッセージ設定
            if (in_itemName.equals("")) {
                ie.setINE("正しい値を入力してください。");
            }
            if (in_price <= -1) {
                ie.setPE("正しい値を入力してください。");
            }

            request.setAttribute("IE", ie);

            //item.jspへ遷移
            RequestDispatcher rde = request.getRequestDispatcher("/WEB-INF/item.jsp");
            rde.forward(request, response);
        }
        else { //入力OKの場合
            //データベース用変数の初期化
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            //データベース接続
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "user", "user");

                //データを追加するSQL文を宣言
                db_st = db_con.prepareStatement("insert into item(itemName,price) values(?,?)");
                db_st.setString(1, in_itemName);
                db_st.setInt(2, in_price);

                //データの追加
                db_st.executeUpdate();
                //Tableの要素を取得
                db_st = db_con.prepareStatement("select * from item");
                db_data = db_st.executeQuery();
                
                out.print("商品情報を追加しました。");
                out.print("<br>");

                //データ表示
                while (db_data.next()) {

                    int itemID = db_data.getInt("itemID");
                    String itemName = db_data.getString("itemName");
                    String price = db_data.getString("price");

                    out.print(itemID + " " + itemName + " " + price);
                    out.print("<br>");

                }

                //クローズ処理
                db_data.close();
                db_st.close();
                db_con.close();
            //データベース接続の例外処理
            } catch (SQLException e_sql) {
                out.print("1.接続時にエラーが発生しました：" + e_sql.toString());
            } catch (Exception e) {
                out.print("2.接続時にエラーが発生しました：" + e.toString());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
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
