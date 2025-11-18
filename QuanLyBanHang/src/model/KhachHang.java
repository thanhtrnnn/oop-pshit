package model;

import java.io.Serializable;

/**
 * Lớp KhachHang đại diện cho thông tin khách hàng
 */
public class KhachHang implements Serializable {
    private static int idCounter = 10000; // Bắt đầu từ 10000 (5 chữ số)
    
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String soDT;
    
    public KhachHang() {
        this.maKH = ++idCounter;
    }
    
    public KhachHang(String hoTen, String diaChi, String soDT) {
        this.maKH = ++idCounter;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    
    public KhachHang(int maKH, String hoTen, String diaChi, String soDT) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        if (maKH >= idCounter) {
            idCounter = maKH;
        }
    }
    
    // Getters and Setters
    public int getMaKH() {
        return maKH;
    }
    
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) throws IllegalArgumentException {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Họ tên không được để trống!");
        }
        this.hoTen = hoTen.trim();
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) throws IllegalArgumentException {
        if (diaChi == null || diaChi.trim().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ không được để trống!");
        }
        this.diaChi = diaChi.trim();
    }
    
    public String getSoDT() {
        return soDT;
    }
    
    public void setSoDT(String soDT) throws IllegalArgumentException {
        if (soDT == null || soDT.trim().isEmpty()) {
            throw new IllegalArgumentException("Số điện thoại không được để trống!");
        }
        // Kiểm tra định dạng số điện thoại (chỉ chứa số)
        if (!soDT.trim().matches("\\d+")) {
            throw new IllegalArgumentException("Số điện thoại chỉ được chứa các chữ số!");
        }
        this.soDT = soDT.trim();
    }
    
    public static void setIdCounter(int counter) {
        idCounter = counter;
    }
    
    public static int getIdCounter() {
        return idCounter;
    }
    
    @Override
    public String toString() {
        return String.format("%d|%s|%s|%s", maKH, hoTen, diaChi, soDT);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KhachHang that = (KhachHang) obj;
        return maKH == that.maKH;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(maKH);
    }
}
