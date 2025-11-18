package gui;

import dao.MatHangDAO;
import model.MatHang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Panel quản lý mặt hàng
 */
public class MatHangPanel extends JPanel {
    private JTextField txtTenHang;
    private JComboBox<String> cboNhomHang;
    private JTextField txtGiaBan;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnThem, btnHienThi, btnLamMoi;
    
    public MatHangPanel() {
        initComponents();
        hienThiDanhSach();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Nhập thông tin mặt hàng"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Tên hàng
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Tên hàng:"), gbc);
        gbc.gridx = 1;
        txtTenHang = new JTextField(20);
        inputPanel.add(txtTenHang, gbc);
        
        // Nhóm hàng
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Nhóm hàng:"), gbc);
        gbc.gridx = 1;
        cboNhomHang = new JComboBox<>(MatHang.NHOM_HANG);
        inputPanel.add(cboNhomHang, gbc);
        
        // Giá bán
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Giá bán:"), gbc);
        gbc.gridx = 1;
        txtGiaBan = new JTextField(20);
        inputPanel.add(txtGiaBan, gbc);
        
        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnThem = new JButton("Thêm mặt hàng");
        btnHienThi = new JButton("Hiển thị danh sách");
        btnLamMoi = new JButton("Làm mới");
        
        btnThem.addActionListener(e -> themMatHang());
        btnHienThi.addActionListener(e -> hienThiDanhSach());
        btnLamMoi.addActionListener(e -> lamMoi());
        
        buttonPanel.add(btnThem);
        buttonPanel.add(btnHienThi);
        buttonPanel.add(btnLamMoi);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // Bảng hiển thị
        String[] columnNames = {"Mã hàng", "Tên hàng", "Nhóm hàng", "Giá bán"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách mặt hàng"));
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void themMatHang() {
        try {
            // Validate input
            if (txtTenHang.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Tên hàng không được để trống!");
            }
            
            if (txtGiaBan.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Giá bán không được để trống!");
            }
            
            // Parse giá bán
            double giaBan;
            try {
                giaBan = Double.parseDouble(txtGiaBan.getText().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Giá bán phải là số!");
            }
            
            // Tạo mặt hàng mới
            MatHang mh = new MatHang();
            mh.setTenHang(txtTenHang.getText().trim());
            mh.setNhomHang((String) cboNhomHang.getSelectedItem());
            mh.setGiaBan(giaBan);
            
            // Lưu vào file
            MatHangDAO.themMatHang(mh);
            
            JOptionPane.showMessageDialog(this, 
                "Thêm mặt hàng thành công!\nMã hàng: " + mh.getMaHang(),
                "Thành công", 
                JOptionPane.INFORMATION_MESSAGE);
            
            lamMoi();
            hienThiDanhSach();
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, 
                e.getMessage(), 
                "Lỗi nhập liệu", 
                JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Lỗi ghi file: " + e.getMessage(), 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void hienThiDanhSach() {
        tableModel.setRowCount(0);
        List<MatHang> danhSach = MatHangDAO.docFile();
        
        for (MatHang mh : danhSach) {
            Object[] row = {
                mh.getMaHang(),
                mh.getTenHang(),
                mh.getNhomHang(),
                String.format("%.2f", mh.getGiaBan())
            };
            tableModel.addRow(row);
        }
    }
    
    private void lamMoi() {
        txtTenHang.setText("");
        cboNhomHang.setSelectedIndex(0);
        txtGiaBan.setText("");
        txtTenHang.requestFocus();
    }
}
