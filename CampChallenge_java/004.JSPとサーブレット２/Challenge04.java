/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

public class Challenge04 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>奇数・偶数の判定</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //計算
            out.print(numCalc(6, 5, false));
            
            
            out.print("<br><br>");
            for(int i=1; i<5; i++) {
                out.print("第1引数："+i+"　第2引数：5"+"　第3引数：false"
                        +"　結果："+numCalc(i, 5, false)+"<br>");
            }
            out.print("<br>");
            for(int i=1; i<5; i++) {
                out.print("第1引数："+i+"　第2引数：3"+"　第3引数：true"
                        +"　結果："+numCalc(i, 3, true)+"<br>");
            }
            
            //out.println("<h1>今日のあなたの運勢は。。。 " + lucklist[index] + "！</h1>");
            out.println("</body>");
            out.println("</html>");
        }finally {
            out.close();
        }
    }
    
    /*
    　課題：計算メソッド
    */
    int numCalc(int num1, int num2, boolean type) {
        num1 = num1 * num2;
        if(type == true) {
            num1 = num1 * num1;
        }
        return num1;
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
