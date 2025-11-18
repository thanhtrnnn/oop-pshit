import java.util.Scanner;
public class j04001_khaibaoloppoint {
    static class point{
        private double x, y;
        point() {
            x = 0; y = 0;
        }

        point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        point(point p) {
            this.x = p.x;
            this.y = p.y;
        }

        public void get(Scanner sc){
            x = sc.nextDouble();
            y = sc.nextDouble();
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        private double distance(point other){
            return Math.sqrt(Math.pow(this.x-other.x,2) + Math.pow(this.y - other.y, 2));
        }
        
        private double distance(point a, point b){
            return Math.sqrt(Math.pow(a.x-b.x,2) + Math.pow(a.y - b.y, 2));
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            point a = new point(); 
            point b = new point();
            a.get(sc);
            b.get(sc);
            System.out.printf("%.4f\n", a.distance(a, b));
        }
        sc.close();
    }
}
