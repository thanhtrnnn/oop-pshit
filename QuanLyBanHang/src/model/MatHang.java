package model;

import java.io.Serializable;

/**
 * Lớp MatHang đại diện cho một mặt hàng trong siêu thị
 */
public class MatHang implements Serializable {
    private static int idCounter = 1000; // Bắt đầu từ 1000 (4 chữ số)
    
    private int maHang;
    private String tenHang;
    private String nhomHang;
    private double giaBan;
    
    // Các nhóm hàng hợp lệ
    public static final String[] NHOM_HANG = {
        "Hàng thời trang",
        "Hàng tiêu dùng",
        "Hàng điện máy",
        "Hàng gia dụng"
    };
    
    public MatHang() {
        this.maHang = ++idCounter;
    }
    
    public MatHang(String tenHang, String nhomHang, double giaBan) {
        this.maHang = ++idCounter;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaBan = giaBan;
    }
    
    public MatHang(int maHang, String tenHang, String nhomHang, double giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaBan = giaBan;
        if (maHang >= idCounter) {
            idCounter = maHang;
        }
    }
    
    // Getters and Setters
    public int getMaHang() {
        return maHang;
    }
    
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }
    
    public String getTenHang() {
        return tenHang;
    }
    
    public void setTenHang(String tenHang) throws IllegalArgumentException {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống!");
        }
        this.tenHang = tenHang.trim();
    }
    
    public String getNhomHang() {
        return nhomHang;
    }
    
    public void setNhomHang(String nhomHang) throws IllegalArgumentException {
        if (nhomHang == null || nhomHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nhóm hàng không được để trống!");
        }
        boolean valid = false;
        for (String nh : NHOM_HANG) {
            if (nh.equals(nhomHang)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Nhóm hàng không hợp lệ!");
        }
        this.nhomHang = nhomHang;
    }
    
    public double getGiaBan() {
        return giaBan;
    }
    
    public void setGiaBan(double giaBan) throws IllegalArgumentException {
        if (giaBan < 0) {
            throw new IllegalArgumentException("Giá bán phải lớn hơn hoặc bằng 0!");
        }
        this.giaBan = giaBan;
    }
    
    public static void setIdCounter(int counter) {
        idCounter = counter;
    }
    
    public static int getIdCounter() {
        return idCounter;
    }
    
    @Override
    public String toString() {
        return String.format("%d|%s|%s|%.2f", maHang, tenHang, nhomHang, giaBan);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MatHang matHang = (MatHang) obj;
        return maHang == matHang.maHang;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(maHang);
    }
}
