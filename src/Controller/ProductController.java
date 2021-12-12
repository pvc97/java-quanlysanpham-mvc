package Controller;

import Model.Product;
import Model.ProductDAO;
import Model.ProductTableModel;
import View.ProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class ProductController {

    private ProductView productView;
    private ProductDAO productDAO;
    
    private ProductTableModel tableModel;

    public ProductController(ProductView view) {
        this.productView = view;

        productDAO = new ProductDAO();
        
        tableModel = new ProductTableModel();

        productView.addAddProductListener(new AddProductListener());

        productView.addTableSelectionListener(new TableSelectionListener());

        productView.addEditProductListener(new EditProductListener());

        productView.addDeleteProductListener(new DeleteProductListener());
    }

    public void showProductView() {

        List<Product> products = productDAO.getListProducts();
        
        tableModel.setData(products);

        productView.setTableModel(tableModel);

        productView.setVisible(true);
    }

    class AddProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.add(product);

                if (success) {
                    tableModel.setData(productDAO.getListProducts());

                    productView.showMessage("Thêm thành công!");
                } else {
                    productView.showMessage("Thêm thất bại!");
                }
            }
        }

    }

    class EditProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.edit(product);

                if (success) {
                    tableModel.setData(productDAO.getListProducts());

                    productView.showMessage("Sửa thành công!");
                } else {
                    productView.showMessage("Sửa thất bại!");
                }
            }
        }
    }

    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.delete(product);

                if (success) {
                    tableModel.setData(productDAO.getListProducts());

                    productView.showMessage("Xóa thành công!");
                } else {
                    productView.showMessage("Xóa thất bại!");
                }
            }
        }
    }

    class TableSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            productView.fillInputForm();
        }
    }
}
