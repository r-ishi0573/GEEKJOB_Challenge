/*
  本プログラムにおけるブラックジャックの仕様
  1.カード「A」は数字の「1」として扱う
  2.ユーザーからの入力は受け付けない
*/

package org.camp.blj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.camp.blj.Dealer;


public class BlackJack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BlackJack</title>");            
            out.println("</head>");
            out.println("<body>");
            
            /* 
               ディーラーの処理
            */
            Dealer dl = new Dealer();
            ArrayList<String> al_Deal = new ArrayList<String>();
            out.print("[ディーラーの処理]<br>");
            out.println("ディールされたカード："+(al_Deal = dl.deal())+"<br>");
            dl.setCard(al_Deal);
            out.println("現在の手札："+dl.myCards+"<br>");
            out.println("現在の合計："+dl.open(dl.myCards)+"<br>");
            boolean dl_flag;
            out.println("17未満か？："+(dl_flag = dl.checkSum(dl.myCards))+"<br>");
            while(dl_flag == true) {
                out.println("<br>ヒットしたカード："+(al_Deal = dl.hit())+"<br>");
                dl.setCard(al_Deal);
                out.println("現在の手札："+dl.myCards+"<br>");
                out.println("現在の合計："+dl.open(dl.myCards)+"<br>");
                out.println("17未満か？："+(dl_flag = dl.checkSum(dl.myCards))+"<br>");
            }
            
            /* 
               ユーザーの処理
            */
            User us = new User();
            ArrayList<String> al_User = new ArrayList<String>();
            out.print("<br><br>[ユーザーの処理]<br>");
            out.println("ディールされたカード："+(al_User = dl.deal())+"<br>");
            us.setCard(al_User);
            out.println("現在の手札："+us.myCards+"<br>");
            out.println("現在の合計："+us.open(us.myCards)+"<br>");
            boolean us_flag;
            out.println("17未満か？："+(us_flag = us.checkSum(us.myCards))+"<br>");
            while(us_flag == true) {
                out.println("<br>ヒットしたカード："+(al_User = dl.hit())+"<br>");
                us.setCard(al_User);
                out.println("現在の手札："+us.myCards+"<br>");
                out.println("現在の合計："+us.open(us.myCards)+"<br>");
                out.println("17未満か？："+(us_flag = us.checkSum(us.myCards))+"<br>");
            }
            
            /*
              勝敗の決定
            */
            int dl_open = dl.open(dl.myCards);
            int us_open = us.open(us.myCards);
            out.print("<br>*******************<br>結果表示<br>*******************");
            out.print("<br>ディーラーの値："+dl_open);
            out.print("<br>ユーザーの値："+us_open);
            
            //ユーザーがバスト
            if(us_open > 21) {
                out.print("<br>あなたの負けです。");
            }
            //ディーラーがバスト
            else if(dl_open > 21) {
                out.print("<br>あなたの勝ちです。");
            }
            else {
                if( us_open > dl_open ) {
                    out.print("<br>あなたの勝ちです。");
                }
                else if( us_open == dl_open ){
                    out.print("<br>引き分けです。");
                }
                else {
                    out.print("<br>あなたの負けです。");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
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
