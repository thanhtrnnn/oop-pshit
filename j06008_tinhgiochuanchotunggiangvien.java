import java.util.*;

public class j06008_tinhgiochuanchotunggiangvien {
    static class Subject {
        String code, name;
        double sum;

        public Subject(String s) {
            String[] a = s.trim().split(" ", 2);
            code = a[0];
            name = a[1];
        }

        public Subject(Subject x) {
            code = x.code;
            name = x.name;
            sum = x.sum;
        }
        
        public boolean is(String s) {
            return s.startsWith(code);
        }

        @Override
        public String toString() {
            return name + ' ' + sum;
        }
    }

    static class GV {
        String code, name;
        double sum;
        ArrayList<Subject> a;

        public GV(String s) {
            a = new ArrayList<>();
            sum = 0;
            String[] a = s.trim().split(" ", 2);
            code = a[0];
            name = a[1];
        }

        public boolean is(String s) {
            return s.startsWith(code);
        }

        public boolean contain(Subject x) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).is(x.code))
                    return true;
            }
            return false;
        }

        public void add(Subject x) {
            if (this.contain(x)) {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i).is(x.code)) {
                        a.get(i).sum += x.sum;
                        break;
                    }
                }
            } else {
                this.a.add(x);
            }
        }
        
        @Override
        public String toString() {
            return name + ' ' + String.format("%.2f", sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Subject> s = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            s.add(new Subject(sc.nextLine()));
        }
        int n = sc.nextInt();
        ArrayList<GV> a = new ArrayList<>();
        sc.nextLine();
        for (int i = 1; i <= n; i++)
            a.add(new GV(sc.nextLine()));
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String gcode = sc.next();
            String scode = sc.next();
            double time = sc.nextDouble();
            int ind = 0;
            Subject x = new Subject(s.get(0));
            for (int j = 0; j < n; j++) {
                if (a.get(j).is(gcode)) {
                    ind = j;
                    break;
                }
            }
            for (int j = 0; j < k; j++) {
                if (s.get(j).is(scode)) {
                    x=new Subject(s.get(j));
                    break;
                }
            }
            x.sum = time;
            a.get(ind).add(x);
            a.get(ind).sum += x.sum;
        }
        String code = sc.next();
        for (int i = 0; i < n; i++) {
            if(a.get(i).is(code)){
                System.out.printf("Giang vien: %s\n", a.get(i).name);
                a.get(i).a.forEach(e -> System.out.println(e));
                System.out.printf("Tong: %.2f", a.get(i).sum);  
            }
        }
        sc.close();
    }
}
