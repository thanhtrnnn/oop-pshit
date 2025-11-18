package gui;

import dao.KhachHangDAO;
import model.KhachHang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Panel quản lý khách hàng
 */
public class KhachHangPanel extends JPanel {
    private JTextField txtHoTen;
    private JTextField txtDiaChi;
    private JTextField txtSoDT;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnThem, btnHienThi, btnLamMoi;
    
    public KhachHangPanel() {
        initComponents();
        hienThiDanhSach();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Nhập thông tin khách hàng"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Họ tên
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Họ tên:"), gbc);
        gbc.gridx = 1;
        txtHoTen = new JTextField(20);
        inputPanel.add(txtHoTen, gbc);
        
        // Địa chỉ
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Địa chỉ:"), gbc);
        gbc.gridx = 1;
        txtDiaChi = new JTextField(20);
        inputPanel.add(txtDiaChi, gbc);
        
        // Số điện thoại
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Số ĐT:"), gbc);
        gbc.gridx = 1;
        txtSoDT = new JTextField(20);
        inputPanel.add(txtSoDT, gbc);
        
        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnThem = new JButton("Thêm khách hàng");
        btnHienThi = new JButton("Hiển thị danh sách");
        btnLamMoi = new JButton("Làm mới");
        
        btnThem.addActionListener(e -> themKhachHang());
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
        String[] columnNames = {"Mã KH", "Họ tên", "Địa chỉ", "Số ĐT"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void themKhachHang() {
        try {
            // Validate input
            if (txtHoTen.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Họ tên không được để trống!");
            }
            
            if (txtDiaChi.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Địa chỉ không được để trống!");
            }
            
            if (txtSoDT.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Số điện thoại không được để trống!");
            }
            
            // Tạo khách hàng mới
            KhachHang kh = new KhachHang();
            kh.setHoTen(txtHoTen.getText().trim());
            kh.setDiaChi(txtDiaChi.getText().trim());
            kh.setSoDT(txtSoDT.getText().trim());
            
            // Lưu vào file
            KhachHangDAO.themKhachHang(kh);
            
            JOptionPane.showMessageDialog(this, 
                "Thêm khách hàng thành công!\nMã KH: " + kh.getMaKH(),
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
        List<KhachHang> danhSach = KhachHangDAO.docFile();
        
        for (KhachHang kh : danhSach) {
            Object[] row = {
                kh.getMaKH(),
                kh.getHoTen(),
                kh.getDiaChi(),
                kh.getSoDT()
            };
            tableModel.addRow(row);
        }
    }
    
    private void lamMoi() {
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtSoDT.setText("");
        txtHoTen.requestFocus();
    }
}
