package dao;

import model.KhachHang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp KhachHangDAO xử lý việc đọc/ghi file KH.TXT
 */
public class KhachHangDAO {
    private static final String FILE_NAME = "KH.TXT";
    
    /**
     * Đọc danh sách khách hàng từ file
     */
    public static List<KhachHang> docFile() {
        List<KhachHang> danhSach = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return danhSach;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 10000;
            
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\|");
                    if (parts.length == 4) {
                        int maKH = Integer.parseInt(parts[0].trim());
                        String hoTen = parts[1].trim();
                        String diaChi = parts[2].trim();
                        String soDT = parts[3].trim();
                        
                        KhachHang kh = new KhachHang(maKH, hoTen, diaChi, soDT);
                        danhSach.add(kh);
                        
                        if (maKH > maxId) {
                            maxId = maKH;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng dữ liệu: " + line);
                }
            }
            
            KhachHang.setIdCounter(maxId);
            
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
        
        return danhSach;
    }
    
    /**
     * Ghi danh sách khách hàng vào file
     */
    public static void ghiFile(List<KhachHang> danhSach) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (KhachHang kh : danhSach) {
                bw.write(kh.toString());
                bw.newLine();
            }
        }
    }
    
    /**
     * Thêm một khách hàng vào file
     */
    public static void themKhachHang(KhachHang kh) throws IOException {
        List<KhachHang> danhSach = docFile();
        danhSach.add(kh);
        ghiFile(danhSach);
    }
    
    /**
     * Tìm khách hàng theo mã
     */
    public static KhachHang timTheoMa(int maKH) {
        List<KhachHang> danhSach = docFile();
        for (KhachHang kh : danhSach) {
            if (kh.getMaKH() == maKH) {
                return kh;
            }
        }
        return null;
    }
}
