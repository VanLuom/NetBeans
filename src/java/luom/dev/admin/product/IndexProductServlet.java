/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package luom.dev.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import luom.dev.admin.BaseAdminServlet;
import luom.dev.data.dao.DatabaseDao;
import luom.dev.data.dao.ProductDao;
import luom.dev.data.dao.model.Product;

/**
 *
 * @author ACER
 */
public class IndexProductServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findAll();

        request.setAttribute("productList", productList);
        request.getRequestDispatcher("admin/products/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
