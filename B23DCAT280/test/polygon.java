package B23DCAT280;

import java.io.*;
import java.util.*;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// Lớp Polygon chứa mảng các Point và phương thức tính diện tích
class Polygon {
    private Point[] p;

    public Polygon(Point[] p) {
        this.p = p;
    }

    public String getArea() {
        double area = 0;
        int n = p.length;
        
        for (int i = 0; i < n; i++) {
            // Áp dụng công thức Shoelace
            // Sử dụng (i + 1) % n để nối điểm cuối cùng quay lại điểm đầu tiên
            Point current = p[i];
            Point next = p[(i + 1) % n];
            
            // Tính tổng chéo: (x_i * y_i+1) - (x_i+1 * y_i)
            area += (double) current.getX() * next.getY();
            area -= (double) current.getY() * next.getX();
        }

        // Lấy giá trị tuyệt đối và chia 2
        area = 0.5 * Math.abs(area);
        
        // Trả về chuỗi định dạng đúng 3 chữ số thập phân
        return String.format("%.3f", area);
    }
}

public class polygon {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("POLYGON.in"));
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            Point p[] = new Point[n];
            for(int i = 0; i < n; i++){
                p[i] = new Point(in.nextInt(),in.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
    }
}