package model;

import java.io.Serializable;

/**
 * Lớp ChiTietMuaHang đại diện cho thông tin mua hàng của khách hàng
 */
public class ChiTietMuaHang implements Serializable {
    private int maKH;
    private int maHang;
    private int soLuong;
    
    // Thông tin bổ sung để hiển thị
    private String tenKH;
    private String tenHang;
    private double giaBan;
    
    public ChiTietMuaHang() {
    }
    
    public ChiTietMuaHang(int maKH, int maHang, int soLuong) {
        this.maKH = maKH;
        this.maHang = maHang;
        this.soLuong = soLuong;
    }
    
    public ChiTietMuaHang(int maKH, int maHang, int soLuong, 
                          String tenKH, String tenHang, double giaBan) {
        this.maKH = maKH;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.tenKH = tenKH;
        this.tenHang = tenHang;
        this.giaBan = giaBan;
    }
    
    // Getters and Setters
    public int getMaKH() {
        return maKH;
    }
    
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    
    public int getMaHang() {
        return maHang;
    }
    
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) throws IllegalArgumentException {
        if (soLuong <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0!");
        }
        this.soLuong = soLuong;
    }
    
    public String getTenKH() {
        return tenKH;
    }
    
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    
    public String getTenHang() {
        return tenHang;
    }
    
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
    public double getGiaBan() {
        return giaBan;
    }
    
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
    public double getThanhTien() {
        return soLuong * giaBan;
    }
    
    @Override
    public String toString() {
        return String.format("%d|%d|%d", maKH, maHang, soLuong);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChiTietMuaHang that = (ChiTietMuaHang) obj;
        return maKH == that.maKH && maHang == that.maHang;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(maKH) * 31 + Integer.hashCode(maHang);
    }
}
