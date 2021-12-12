package View;

import Model.Product;
import Model.ProductTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class ProductView extends JFrame {

    

    private JTable table;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnCancel;

    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtQuantity;

    public ProductView() {
        super("Quản lý sản phẩm");

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        table = new JTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }

    private JPanel createControlPanel() {
        JPanel controPanel = new JPanel();
        controPanel.setLayout(new FlowLayout());

        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        btnSave = new JButton("Ghi");
        btnCancel = new JButton("Hủy");
        
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        
        
        controPanel.add(btnAdd);
        controPanel.add(btnEdit);
        controPanel.add(btnDelete);
        controPanel.add(btnSave);
        controPanel.add(btnCancel);

        return controPanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        txtID = new JTextField();
        txtName = new JTextField();
        txtQuantity = new JTextField();
        
        txtID.setEnabled(false);
        
        inputPanel.add(new JLabel("ID"));
        inputPanel.add(txtID);
        inputPanel.add(new JLabel("Tên sản phẩm"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Số lượng"));
        inputPanel.add(txtQuantity);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return inputPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(createControlPanel(), BorderLayout.CENTER);
        bottomPanel.add(createInputPanel(), BorderLayout.SOUTH);

        return bottomPanel;
    }
    
    public void setTableModel(ProductTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public void addAddProductListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }
    
    public void addEditProductListener(ActionListener listener) {
        btnEdit.addActionListener(listener);
    }
    
    public void addDeleteProductListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }
    
    public void addTableSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }
    
    private boolean validateProductData(String name, int quantity) {
        if (name.length() == 0 || quantity == 0) {
            return false;
        }
        
        return true;
    }
    
    public Product getProductData() {
        
        int id = 0;
        try {
            id = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException ex) {
            
        }
        
        String name = txtName.getText();
        
        int quantity = 0;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException ex) {
            
        }
        
        if (validateProductData(name, quantity) == false) {
            showMessage("Thông tin không hợp lệ!");
            return null;
        }
        
        Product product = new Product(id, name, quantity);
        
        return product;
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void fillInputForm() {
        int row = table.getSelectedRow();
        
        if (row >= 0) {
            txtID.setText(table.getValueAt(row, 0).toString());
            txtName.setText(table.getValueAt(row, 1).toString());
            txtQuantity.setText(table.getValueAt(row, 2).toString());
        }
    }
}
