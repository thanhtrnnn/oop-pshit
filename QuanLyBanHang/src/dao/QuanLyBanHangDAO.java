package dao;

import model.ChiTietMuaHang;
import model.KhachHang;
import model.MatHang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Lớp QuanLyBanHangDAO xử lý việc đọc/ghi file QLBH.TXT
 */
public class QuanLyBanHangDAO {
    private static final String FILE_NAME = "QLBH.TXT";
    
    /**
     * Đọc danh sách mua hàng từ file
     */
    public static List<ChiTietMuaHang> docFile() {
        List<ChiTietMuaHang> danhSach = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return danhSach;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        int maKH = Integer.parseInt(parts[0].trim());
                        int maHang = Integer.parseInt(parts[1].trim());
                        int soLuong = Integer.parseInt(parts[2].trim());
                        
                        // Lấy thông tin bổ sung
                        KhachHang kh = KhachHangDAO.timTheoMa(maKH);
                        MatHang mh = MatHangDAO.timTheoMa(maHang);
                        
                        if (kh != null && mh != null) {
                            ChiTietMuaHang ct = new ChiTietMuaHang(
                                maKH, maHang, soLuong,
                                kh.getHoTen(), mh.getTenHang(), mh.getGiaBan()
                            );
                            danhSach.add(ct);
                        } else {
                            ChiTietMuaHang ct = new ChiTietMuaHang(maKH, maHang, soLuong);
                            danhSach.add(ct);
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng dữ liệu: " + line);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
        
        return danhSach;
    }
    
    /**
     * Ghi danh sách mua hàng vào file
     */
    public static void ghiFile(List<ChiTietMuaHang> danhSach) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (ChiTietMuaHang ct : danhSach) {
                bw.write(ct.toString());
                bw.newLine();
            }
        }
    }
    
    /**
     * Thêm một chi tiết mua hàng vào file
     * Kiểm tra không cho phép trùng (maKH, maHang)
     */
    public static void themChiTiet(ChiTietMuaHang ct) throws IOException {
        List<ChiTietMuaHang> danhSach = docFile();
        
        // Kiểm tra trùng
        for (ChiTietMuaHang item : danhSach) {
            if (item.getMaKH() == ct.getMaKH() && item.getMaHang() == ct.getMaHang()) {
                throw new IllegalArgumentException(
                    "Khách hàng này đã mua mặt hàng này rồi! Không thể thêm trùng."
                );
            }
        }
        
        danhSach.add(ct);
        ghiFile(danhSach);
    }
    
    /**
     * Sắp xếp theo tên khách hàng
     */
    public static List<ChiTietMuaHang> sapXepTheoTenKH() {
        List<ChiTietMuaHang> danhSach = docFile();
        danhSach.sort(Comparator.comparing(ChiTietMuaHang::getTenKH));
        return danhSach;
    }
    
    /**
     * Sắp xếp theo tên mặt hàng
     */
    public static List<ChiTietMuaHang> sapXepTheoTenMatHang() {
        List<ChiTietMuaHang> danhSach = docFile();
        danhSach.sort(Comparator.comparing(ChiTietMuaHang::getTenHang));
        return danhSach;
    }
    
    /**
     * Lấy danh sách mua hàng của một khách hàng
     */
    public static List<ChiTietMuaHang> layDanhSachTheoKH(int maKH) {
        List<ChiTietMuaHang> danhSach = docFile();
        List<ChiTietMuaHang> ketQua = new ArrayList<>();
        
        for (ChiTietMuaHang ct : danhSach) {
            if (ct.getMaKH() == maKH) {
                ketQua.add(ct);
            }
        }
        
        return ketQua;
    }
}
