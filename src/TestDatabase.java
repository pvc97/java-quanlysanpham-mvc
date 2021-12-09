
import Model.Product;
import Model.ProductDAO;
import com.mysql.jdbc.Connection;
import java.util.List;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class TestDatabase {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

//        List<Product> products = productDAO.getListProducts();
        // CRUD
        // C - CREATE : Thêm
        // R - READ: đọc getListProducts();
        // U - UPDATE 
        // D - DELETE
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }
//        Product newProduct = new Product("monitor", 9);
//        if (productDAO.add(newProduct)) {
//            System.out.println("Them thanh cong");
//        } else {
//            System.out.println("Them that bai");
//        }
//        Product newProduct = new Product(2, "iphone", 999);
//        if (productDAO.edit(newProduct)) {
//            System.out.println("sua thanh cong");
//        } else {
//            System.out.println("sua that bai");
//        }

//        Product newProduct = new Product(2, "iphone", 999);
//        if (productDAO.delete(newProduct)) {
//            System.out.println("Xoa thanh cong");
//        } else {
//            System.out.println("Xoa that bai");
//        }
    }
}
