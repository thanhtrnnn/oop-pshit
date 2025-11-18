package gui;

import javax.swing.*;

/**
 * Cửa sổ chính của ứng dụng
 */
public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private MatHangPanel matHangPanel;
    private KhachHangPanel khachHangPanel;
    private QuanLyBanHangPanel quanLyBanHangPanel;
    private HoaDonPanel hoaDonPanel;
    
    public MainFrame() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Hệ thống quản lý bán hàng siêu thị");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        
        // Tạo tabbed pane
        tabbedPane = new JTabbedPane();
        
        // Tạo các panel
        matHangPanel = new MatHangPanel();
        khachHangPanel = new KhachHangPanel();
        quanLyBanHangPanel = new QuanLyBanHangPanel();
        hoaDonPanel = new HoaDonPanel();
        
        // Thêm các tab
        tabbedPane.addTab("Quản lý mặt hàng", createIcon("🛒"), matHangPanel, "Thêm và xem danh sách mặt hàng");
        tabbedPane.addTab("Quản lý khách hàng", createIcon("👥"), khachHangPanel, "Thêm và xem danh sách khách hàng");
        tabbedPane.addTab("Quản lý bán hàng", createIcon("📊"), quanLyBanHangPanel, "Lập danh sách mua hàng");
        tabbedPane.addTab("Hóa đơn", createIcon("🧾"), hoaDonPanel, "Xem hóa đơn chi tiết");
        
        // Lắng nghe sự kiện chuyển tab
        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            if (selectedIndex == 2) { // Tab Quản lý bán hàng
                quanLyBanHangPanel.refresh();
            } else if (selectedIndex == 3) { // Tab Hóa đơn
                hoaDonPanel.refresh();
            }
        });
        
        add(tabbedPane);
        
        // Tạo menu bar
        createMenuBar();
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Menu Hệ thống
        JMenu menuHeThong = new JMenu("Hệ thống");
        JMenuItem itemThoat = new JMenuItem("Thoát");
        itemThoat.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn thoát?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menuHeThong.add(itemThoat);
        
        // Menu Trợ giúp
        JMenu menuTroGiup = new JMenu("Trợ giúp");
        JMenuItem itemGioiThieu = new JMenuItem("Giới thiệu");
        itemGioiThieu.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Hệ thống quản lý bán hàng siêu thị\n" +
                "Phiên bản 1.0\n" +
                "Phát triển bởi: Lê Duy Anh (B23DCCN026)",
                "Giới thiệu",
                JOptionPane.INFORMATION_MESSAGE);
        });
        menuTroGiup.add(itemGioiThieu);
        
        menuBar.add(menuHeThong);
        menuBar.add(menuTroGiup);
        
        setJMenuBar(menuBar);
    }
    
    private ImageIcon createIcon(String emoji) {
        // Tạo icon đơn giản từ text
        return null; // Có thể bỏ qua hoặc sử dụng icon thực
    }
}
