/**
 * 課題5のソース修正の提出
 * 既にsessionにBeansがある場合はそのBeansをinsert.jspに渡すように変更
 */

package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insert.jspと対応するサーブレット
 * @author hayashi-s
 */
public class Insert extends HttpServlet {

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
        HttpSession session = request.getSession();
        //session.setAttribute("ac", (int) (Math.random() * 1000));
        
        /*
          課題5のソースの修正
        */
        UserDataBeans udb;
        //初期接続等の場合、新たにBeansインスタンス作成
        if((UserDataBeans)session.getAttribute("UDB") == null) {
            udb = new UserDataBeans();
        }
        //すでにsessionにBeansが存在している場合(他ページからリンクで飛んできた)
        else {
            udb = (UserDataBeans)session.getAttribute("UDB");
        }
        /*
          課題5ここまで
        */
        
        udb.setIsAccess((int)(Math.random() * 1000));
        session.setAttribute("UDB", udb);
        
        request.getRequestDispatcher("/insert.jsp").forward(request, response);   
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
