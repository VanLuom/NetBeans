/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package luom.dev.admin.orderDetail;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import luom.dev.admin.BaseAdminServlet;
import luom.dev.data.dao.Database;
import luom.dev.data.dao.OrderDetailDao;
import luom.dev.data.dao.model.OrderDetail;

/**
 *
 * @author ACER
 */
public class IndexOrderDetailServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        OrderDetailDao orderDetailDao = Database.getInstance().getOrderDetailDao();
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrder(orderId);

        request.setAttribute("orderDetailList", orderDetailList);
        request.getRequestDispatcher("admin/orderDetail/show.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
