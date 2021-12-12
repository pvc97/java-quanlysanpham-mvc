package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class ProductTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Tên sản phẩm", "Số lượng"};
    private List<Product> products;

    public ProductTableModel() {
        products = new ArrayList<>();
    }

    public void setData(List<Product> products) {
        this.products = products;

        // Mỗi khi dữ liệu của tableModel được cập nhật qua hàm setData thì 
        // tableModel sẽ thông báo cho cái table trong View cập lại
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Product product = products.get(row);

        switch (col) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getQuantity();
        }

        return null;
    }

}
