/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.chl04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;


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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Challenge04</title>");            
            out.println("</head>");
            out.println("<body>");
            
            /*
              2015/1/1のタイムスタンプ取得
            */
            Calendar cal1 = Calendar.getInstance();
            cal1.set(2015,0,1,0,0,0);
            Date date1 = cal1.getTime();
            out.print("日時："+date1);
            out.print("<br>");
            out.print("タイムスタンプ："+date1.getTime());
            out.print("<br><br>");
            
            int yy = cal1.get(Calendar.YEAR);
            int MM = cal1.get(Calendar.MONTH)+1;
            int dd = cal1.get(Calendar.DAY_OF_MONTH);
            int hh = cal1.get(Calendar.HOUR_OF_DAY);
            int mm = cal1.get(Calendar.MINUTE);
            int ss = cal1.get(Calendar.SECOND);
            
            out.print(yy+"年"+MM+"月"+dd+"日 "+hh+"時"+mm+"分"+ss+"秒<br>");
            out.print("<br><br>");
            
            /*
              2015/12/31のタイムスタンプ取得
            */
            Calendar cal2 = Calendar.getInstance();
            cal2.set(2015,11,31,23,59,59);
            Date date2 = cal2.getTime();
            out.print("日時："+date2);
            out.print("<br>");
            out.print("タイムスタンプ："+date2.getTime());
            out.print("<br><br>");
            
            int yy2 = cal2.get(Calendar.YEAR);
            int MM2 = cal2.get(Calendar.MONTH)+1;
            int dd2 = cal2.get(Calendar.DAY_OF_MONTH);
            int hh2 = cal2.get(Calendar.HOUR_OF_DAY);
            int mm2 = cal2.get(Calendar.MINUTE);
            int ss2 = cal2.get(Calendar.SECOND);
            
            out.print(yy2+"年"+MM2+"月"+dd2+"日 "+hh2+"時"+mm2+"分"+ss2+"秒<br>");
            out.print("<br><br>");
            
            
            out.print("タイムスタンプの差：");
            out.print(date2.getTime() - date1.getTime());
            
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
