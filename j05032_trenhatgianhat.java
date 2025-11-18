import java.util.*;
import java.text.*;
public class j05032_trenhatgianhat {
    
    static class person {
        String name, d, m, y;
        Date date;

        public person(String name, String date){
            this.name = name;
            String[] a = date.split("/");
            d = a[0];
            m = a[1];
            y = a[2];
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<person> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new person(sc.next(), sc.next()));
        }
        a.sort((person x, person y) -> {
            if(x.y.compareTo(y.y) == 0){
                if(x.m.compareTo(y.m) == 0){
                    return x.d.compareTo(y.d);
                }
                return x.m.compareTo(y.m);
            }
            return x.y.compareTo(y.y);
        });
        System.out.println(a.get(n-1));
        System.out.println(a.get(0));
        sc.close();
    }
}
