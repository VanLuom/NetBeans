package luom.dev.data.dao.impl;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import luom.dev.data.dao.ProductDao;
import luom.dev.data.dao.model.Product;
import luom.dev.data.driver.MySQLDriver;

public class ProductDaoImp implements ProductDao {

    private final Connection conn;

    public ProductDaoImp() {
        this.conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, PRICE, QUANTITY, VIEW, CATEGORY_ID, CREATED_AT)VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getView());
            stmt.setInt(6, product.getCategoryId());
            stmt.setTimestamp(7, product.getCreatedAt());
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception

        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, PRICE=?, QUANTITY=?, VIEW=?, CATEGORY_ID=?, CREATED_AT=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getView());
            stmt.setInt(6, product.getCategoryId());
            stmt.setTimestamp(7, product.getCreatedAt());
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "DELETE FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Product find(int id) {
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                return new Product(id, name, description, price, quantity, view, categoryId, createdAt);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT *FROM PRODUCTS WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                productList.add(new Product(id, name, descripton, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException ex) {
            // TODO: handle exception
        }
        return productList;
    }}
