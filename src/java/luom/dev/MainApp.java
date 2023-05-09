package luom.dev;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import luom.dev.data.dao.ProductDao;
import luom.dev.data.dao.UserDao;
import luom.dev.data.dao.impl.CategoryDaoImp;
import luom.dev.data.dao.impl.ProductDaoImp;
import luom.dev.data.dao.impl.UserDaoImp;
import luom.dev.data.dao.model.Category;
import luom.dev.data.dao.model.Product;
import luom.dev.data.dao.model.User;

public class MainApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserDao userDao = new UserDaoImp();
        User user = new User("hihi", "lluom14@gmail.com", "123", "admin");
        userDao.insert(user);
//////		
//////		CategoryDao categorydao = new CategoryDaoImp();
//////		Category category = new Category("Luom", "https://localhost/public/img1.jpg");
//////		categorydao.insert(category);
//		
//        ProductDao productdao = new ProductDaoImp();
//        Product product = new Product("trung", "bao", "public/images/product-01.jpg", 2, 2, 2, 2);
//        productdao.insert(product);
//    }

    }
}
