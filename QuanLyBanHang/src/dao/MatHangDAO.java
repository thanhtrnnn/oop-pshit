package dao;

import model.MatHang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp MatHangDAO xử lý việc đọc/ghi file MH.TXT
 */
public class MatHangDAO {
    private static final String FILE_NAME = "MH.TXT";
    
    /**
     * Đọc danh sách mặt hàng từ file
     */
    public static List<MatHang> docFile() {
        List<MatHang> danhSach = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return danhSach;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 1000;
            
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\|");
                    if (parts.length == 4) {
                        int maHang = Integer.parseInt(parts[0].trim());
                        String tenHang = parts[1].trim();
                        String nhomHang = parts[2].trim();
                        double giaBan = Double.parseDouble(parts[3].trim());
                        
                        MatHang mh = new MatHang(maHang, tenHang, nhomHang, giaBan);
                        danhSach.add(mh);
                        
                        if (maHang > maxId) {
                            maxId = maHang;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng dữ liệu: " + line);
                }
            }
            
            MatHang.setIdCounter(maxId);
            
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
        
        return danhSach;
    }
    
    /**
     * Ghi danh sách mặt hàng vào file
     */
    public static void ghiFile(List<MatHang> danhSach) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MatHang mh : danhSach) {
                bw.write(mh.toString());
                bw.newLine();
            }
        }
    }
    
    /**
     * Thêm một mặt hàng vào file
     */
    public static void themMatHang(MatHang mh) throws IOException {
        List<MatHang> danhSach = docFile();
        danhSach.add(mh);
        ghiFile(danhSach);
    }
    
    /**
     * Tìm mặt hàng theo mã
     */
    public static MatHang timTheoMa(int maHang) {
        List<MatHang> danhSach = docFile();
        for (MatHang mh : danhSach) {
            if (mh.getMaHang() == maHang) {
                return mh;
            }
        }
        return null;
    }
}
