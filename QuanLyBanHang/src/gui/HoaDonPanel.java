package gui;

import dao.KhachHangDAO;
import dao.QuanLyBanHangDAO;
import model.ChiTietMuaHang;
import model.KhachHang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Panel lập hóa đơn cho khách hàng
 */
public class HoaDonPanel extends JPanel {
    private JComboBox<String> cboKhachHang;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnXemHoaDon;
    private JLabel lblTongTien;
    private List<KhachHang> danhSachKH;
    
    public HoaDonPanel() {
        initComponents();
        loadComboBoxData();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel chọn khách hàng
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createTitledBorder("Chọn khách hàng"));
        
        topPanel.add(new JLabel("Khách hàng:"));
        cboKhachHang = new JComboBox<>();
        cboKhachHang.setPreferredSize(new Dimension(300, 25));
        topPanel.add(cboKhachHang);
        
        btnXemHoaDon = new JButton("Xem hóa đơn");
        btnXemHoaDon.addActionListener(e -> xemHoaDon());
        topPanel.add(btnXemHoaDon);
        
        add(topPanel, BorderLayout.NORTH);
        
        // Bảng hiển thị
        String[] columnNames = {"STT", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
        add(scrollPane, BorderLayout.CENTER);
        
        // Panel tổng tiền
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(new JLabel("Tổng tiền:"));
        lblTongTien = new JLabel("0.00");
        lblTongTien.setFont(new Font("Arial", Font.BOLD, 16));
        lblTongTien.setForeground(Color.RED);
        bottomPanel.add(lblTongTien);
        
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void loadComboBoxData() {
        cboKhachHang.removeAllItems();
        danhSachKH = KhachHangDAO.docFile();
        for (KhachHang kh : danhSachKH) {
            cboKhachHang.addItem(kh.getMaKH() + " - " + kh.getHoTen());
        }
    }
    
    private void xemHoaDon() {
        try {
            if (cboKhachHang.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, 
                    "Vui lòng chọn khách hàng!",
                    "Thông báo", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            KhachHang kh = danhSachKH.get(cboKhachHang.getSelectedIndex());
            List<ChiTietMuaHang> danhSach = QuanLyBanHangDAO.layDanhSachTheoKH(kh.getMaKH());
            
            tableModel.setRowCount(0);
            double tongTien = 0;
            int stt = 1;
            
            for (ChiTietMuaHang ct : danhSach) {
                Object[] row = {
                    stt++,
                    ct.getTenHang(),
                    ct.getSoLuong(),
                    String.format("%.2f", ct.getGiaBan()),
                    String.format("%.2f", ct.getThanhTien())
                };
                tableModel.addRow(row);
                tongTien += ct.getThanhTien();
            }
            
            lblTongTien.setText(String.format("%.2f VNĐ", tongTien));
            
            if (danhSach.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Khách hàng này chưa mua hàng!",
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Lỗi: " + e.getMessage(),
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refresh() {
        loadComboBoxData();
        tableModel.setRowCount(0);
        lblTongTien.setText("0.00");
    }
}
