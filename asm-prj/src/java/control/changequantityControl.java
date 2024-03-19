/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.Account;
import entity.Item;
import entity.ItemCart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
@WebServlet(name="changequantityControl", urlPatterns={"/changequantity"})
public class changequantityControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String iid = request.getParameter("iid");
        String type = request.getParameter("type");
        DAO dao = new DAO();
        dao.updownInCart(iid, type);
        
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String accName = a.getUsername();
        
        List<Item> list = dao.getAllItemInCart(accName);
        List<ItemCart> listItemCart = new ArrayList<>();
        for (Item i : list){
            listItemCart.add(new ItemCart(i.getiID(), dao.getProductByID(i.getpID()), i.getQuantity(),dao.getProductByID(i.getiID()).getPrice()));
        }
        long total = 0;
        for (ItemCart ic : listItemCart){
            total = total + ic.getQuantity() * ic.getP().getPricediscount();
        }
        request.setAttribute("total",total);
        request.setAttribute("listI", listItemCart);
        session.setAttribute("listI", listItemCart);
        session.setAttribute("total", total);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
