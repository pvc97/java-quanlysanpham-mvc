package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class ProductView extends JFrame{
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
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm", "Số lượng",
            }
        ));
        
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
        
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    private JPanel createControlPanel() {
        JPanel controPanel = new JPanel();
        controPanel.setLayout(new FlowLayout());
        
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        btnSave = new JButton("Ghi");
        btnCancel = new JButton("Hủy");
        
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
}
