import java.util.*;
public class j05026_danhsachgiangvientheobomon {

    static String first(String s){
        String[] a = s.split("\\s+");
        String r = "";
        for(String x:a){
            r+=Character.toString(x.charAt(0)).toUpperCase();
        }
        return r;
    }
    
    static class GV {
        String code, name, field, last;

        public GV(int i, String name, String s){
            code = "GV" + String.format("%02d", i);
            String[] a = name.split("\\s+");
            last = a[a.length - 1];
            this.name = name;
            String[] b = s.split("\\s+");
            field = first(s);
        }

        public String toString() {
            return code + ' ' + name + ' ' + field;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<GV> a = new ArrayList<>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            a.add(new GV(i+1, sc.nextLine(), sc.nextLine()));
        }
        int q = sc.nextInt();
        sc.nextLine();
        while(q-->0){
            String s = first(sc.nextLine());
            System.out.printf("DANH SACH GIANG VIEN BO MON %s:\n", s.toUpperCase());
            a.forEach(e -> {
                if(e.field.compareTo(s) == 0) System.out.println(e);
            });
        }
        sc.close();
    }
}
