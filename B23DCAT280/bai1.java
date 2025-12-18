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

class Polygon {
    private Point[] p;

    public Polygon(Point[] p) {
        this.p = p;
    }

    public String getArea() {
        double area = 0;
        int n = p.length;
        
        for (int i = 0; i < n; i++) {
            Point current = p[i];
            Point next = p[(i + 1) % n];
            area += (double) current.getX() * next.getY();
            area -= (double) current.getY() * next.getX();
        }

        area = Math.abs(area) / 2;
        return String.format("%.3f", area);
    }
}

public class bai1 {
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