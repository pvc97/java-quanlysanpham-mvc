package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class ProductDAO {
    public ProductDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Can't load driver!");
        }
    }
    
    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/qlsp";
        
        try {
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            
            System.out.println("Database connected");
            
            return con;
        } catch (SQLException ex) {
            
            System.out.println("Can't connect to database");
            throw new RuntimeException(ex);
        }
    }
    
    private void closeConnection(Connection con) {
        try {
            con.close();
            System.out.println("Database closed");
        } catch (SQLException ex) {
            System.out.println("Can't close connection");
        }
    }
    
    public List<Product> getListProducts() {
        Connection con = getConnection();
        
        List<Product> products = new ArrayList<>();
        
        String sql = "SELECT * FROM product";
        
        try {
            Statement selectStatement = con.createStatement();
            
            ResultSet result = selectStatement.executeQuery(sql);
            
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                
                Product product = new Product(id, name, quantity);
                
                products.add(product);
            }
            
            selectStatement.close();
            result.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con);
        }
        
        return products;
    }
    
    public boolean add(Product product) {
        Connection con = getConnection();
        
        String sql = "INSERT INTO product(name, quantity) VALUES (?, ?)";
        
        try {
            PreparedStatement insertStatement = con.prepareStatement(sql);
            
            insertStatement.setString(1, product.getName());
            insertStatement.setInt(2, product.getQuantity());
            
            insertStatement.executeUpdate();
            
            insertStatement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con);
        }
        
        return false;
    }
    
    public boolean edit(Product product) {
        Connection con = getConnection();
        
        String sql = "UPDATE product set name = ?, quantity = ? WHERE id = ?";
        
        try {
            PreparedStatement updateStatement = con.prepareStatement(sql);
            
            updateStatement.setString(1, product.getName());
            updateStatement.setInt(2, product.getQuantity());
            updateStatement.setInt(3, product.getId());
            
            updateStatement.executeUpdate();
            
            updateStatement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con);
        }
        
        return false;
    }
    
    public boolean delete(Product product) {
        Connection con = getConnection();
        
        String sql = "DELETE FROM product WHERE id = ?";
        
        try {
            PreparedStatement deleteStatement = con.prepareStatement(sql);
            
            deleteStatement.setInt(1, product.getId());
            
            deleteStatement.executeUpdate();
            
            deleteStatement.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(con);
        }
        
        return false;
    }
}
