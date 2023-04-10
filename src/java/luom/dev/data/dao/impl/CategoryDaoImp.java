package luom.dev.data.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import luom.dev.data.dao.CategoryDao;
import luom.dev.data.dao.model.Category;
import luom.dev.data.driver.MySQLDriver;

public class CategoryDaoImp implements CategoryDao {
	private final Connection conn;
	
	public CategoryDaoImp() {
		this.conn = MySQLDriver.getInstance().getConnection();
	}

	@Override
	public boolean insert(Category category) {
		try {
            String sql = "INSERT INTO CATEGORIES(id, name, image) VALUES(NULL, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());
           

           return stmt.execute();
        } catch (SQLException e) {
                    // TODO: handle exception

        }
		return false;
	}

	@Override
	public boolean update(Category category) {
		try {
            String sql = "UPDATE CATEGORIES SET NAME=?, Image=?, WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImage());
            
            stmt.setInt(4, category.getId());

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        	e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
            Connection conn = MySQLDriver.getInstance().getConnection();
            String sql = "DELETE FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
		return false;
	}

	@Override
	public Category find(int id) {
		 try {
	            String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	             
	                String name = rs.getString("name");
	                String image = rs.getString("image");
	                return new Category(id, name, image);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
		return null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categoryList = new ArrayList<Category>();

        try {
            String sql = "SELECT * FROM CATEGORIES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");

                categoryList.add(new Category(id, name, image));
            }
        } catch (SQLException ex) {
        }

        return categoryList;
	}
	
	
	

}
