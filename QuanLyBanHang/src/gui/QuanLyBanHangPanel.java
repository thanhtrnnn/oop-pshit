package gui;

import dao.KhachHangDAO;
import dao.MatHangDAO;
import dao.QuanLyBanHangDAO;
import model.ChiTietMuaHang;
import model.KhachHang;
import model.MatHang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Panel quản lý bán hàng
 */
public class QuanLyBanHangPanel extends JPanel {
    private JComboBox<String> cboKhachHang;
    private JComboBox<String> cboMatHang;
    private JTextField txtSoLuong;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnThem, btnHienThi, btnSapXepKH, btnSapXepMH;
    private List<KhachHang> danhSachKH;
    private List<MatHang> danhSachMH;
    
    public QuanLyBanHangPanel() {
        initComponents();
        loadComboBoxData();
        hienThiDanhSach();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Nhập thông tin mua hàng"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Khách hàng
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Khách hàng:"), gbc);
        gbc.gridx = 1;
        cboKhachHang = new JComboBox<>();
        cboKhachHang.setPreferredSize(new Dimension(300, 25));
        inputPanel.add(cboKhachHang, gbc);
        
        // Mặt hàng
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Mặt hàng:"), gbc);
        gbc.gridx = 1;
        cboMatHang = new JComboBox<>();
        cboMatHang.setPreferredSize(new Dimension(300, 25));
        inputPanel.add(cboMatHang, gbc);
        
        // Số lượng
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Số lượng:"), gbc);
        gbc.gridx = 1;
        txtSoLuong = new JTextField(20);
        inputPanel.add(txtSoLuong, gbc);
        
        // Panel nút
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnThem = new JButton("Thêm");
        btnHienThi = new JButton("Hiển thị");
        btnSapXepKH = new JButton("Sắp xếp theo KH");
        btnSapXepMH = new JButton("Sắp xếp theo MH");
        
        btnThem.addActionListener(e -> themChiTiet());
        btnHienThi.addActionListener(e -> hienThiDanhSach());
        btnSapXepKH.addActionListener(e -> sapXepTheoKH());
        btnSapXepMH.addActionListener(e -> sapXepTheoMH());
        
        buttonPanel.add(btnThem);
        buttonPanel.add(btnHienThi);
        buttonPanel.add(btnSapXepKH);
        buttonPanel.add(btnSapXepMH);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);
        
        add(inputPanel, BorderLayout.NORTH);
        
        // Bảng hiển thị
        String[] columnNames = {"Mã KH", "Tên KH", "Mã hàng", "Tên hàng", "Số lượng", "Giá bán", "Thành tiền"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách mua hàng"));
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadComboBoxData() {
        // Load khách hàng
        cboKhachHang.removeAllItems();
        danhSachKH = KhachHangDAO.docFile();
        for (KhachHang kh : danhSachKH) {
            cboKhachHang.addItem(kh.getMaKH() + " - " + kh.getHoTen());
        }
        
        // Load mặt hàng
        cboMatHang.removeAllItems();
        danhSachMH = MatHangDAO.docFile();
        for (MatHang mh : danhSachMH) {
            cboMatHang.addItem(mh.getMaHang() + " - " + mh.getTenHang());
        }
    }
    
    private void themChiTiet() {
        try {
            // Validate
            if (cboKhachHang.getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Vui lòng chọn khách hàng!");
            }
            
            if (cboMatHang.getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Vui lòng chọn mặt hàng!");
            }
            
            if (txtSoLuong.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Số lượng không được để trống!");
            }
            
            int soLuong;
            try {
                soLuong = Integer.parseInt(txtSoLuong.getText().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Số lượng phải là số nguyên!");
            }
            
            if (soLuong <= 0) {
                throw new IllegalArgumentException("Số lượng phải lớn hơn 0!");
            }
            
            // Lấy thông tin
            KhachHang kh = danhSachKH.get(cboKhachHang.getSelectedIndex());
            MatHang mh = danhSachMH.get(cboMatHang.getSelectedIndex());
            
            // Tạo chi tiết mua hàng
            ChiTietMuaHang ct = new ChiTietMuaHang(
                kh.getMaKH(), mh.getMaHang(), soLuong,
                kh.getHoTen(), mh.getTenHang(), mh.getGiaBan()
            );
            
            // Lưu vào file
            QuanLyBanHangDAO.themChiTiet(ct);
            
            JOptionPane.showMessageDialog(this, 
                "Thêm chi tiết mua hàng thành công!",
                "Thành công", 
                JOptionPane.INFORMATION_MESSAGE);
            
            txtSoLuong.setText("");
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
        List<ChiTietMuaHang> danhSach = QuanLyBanHangDAO.docFile();
        
        for (ChiTietMuaHang ct : danhSach) {
            Object[] row = {
                ct.getMaKH(),
                ct.getTenKH(),
                ct.getMaHang(),
                ct.getTenHang(),
                ct.getSoLuong(),
                String.format("%.2f", ct.getGiaBan()),
                String.format("%.2f", ct.getThanhTien())
            };
            tableModel.addRow(row);
        }
    }
    
    private void sapXepTheoKH() {
        tableModel.setRowCount(0);
        List<ChiTietMuaHang> danhSach = QuanLyBanHangDAO.sapXepTheoTenKH();
        
        for (ChiTietMuaHang ct : danhSach) {
            Object[] row = {
                ct.getMaKH(),
                ct.getTenKH(),
                ct.getMaHang(),
                ct.getTenHang(),
                ct.getSoLuong(),
                String.format("%.2f", ct.getGiaBan()),
                String.format("%.2f", ct.getThanhTien())
            };
            tableModel.addRow(row);
        }
        
        JOptionPane.showMessageDialog(this, 
            "Đã sắp xếp theo tên khách hàng!",
            "Thông báo", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void sapXepTheoMH() {
        tableModel.setRowCount(0);
        List<ChiTietMuaHang> danhSach = QuanLyBanHangDAO.sapXepTheoTenMatHang();
        
        for (ChiTietMuaHang ct : danhSach) {
            Object[] row = {
                ct.getMaKH(),
                ct.getTenKH(),
                ct.getMaHang(),
                ct.getTenHang(),
                ct.getSoLuong(),
                String.format("%.2f", ct.getGiaBan()),
                String.format("%.2f", ct.getThanhTien())
            };
            tableModel.addRow(row);
        }
        
        JOptionPane.showMessageDialog(this, 
            "Đã sắp xếp theo tên mặt hàng!",
            "Thông báo", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void refresh() {
        loadComboBoxData();
        hienThiDanhSach();
    }
}
