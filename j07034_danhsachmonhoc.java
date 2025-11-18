import java.util.*;
import java.io.File;
import java.io.IOException;

public class j07034_danhsachmonhoc {
    static class sub{
        String code, name, method;
        public sub(String c, String n, String m){
            code=c;
            name=n;
            method=m;
        }
        public boolean big(sub b){
            if(name.compareTo(b.name) > 0) return true;
            return false;
        }
        public String toString(){
            return code + " " + name + " " + method;
        }
    }
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sub[] a = new sub[n];
        sc.nextLine();
        for(int i=0; i<n; i++){
            a[i] = new sub(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Collections.sort(Arrays.asList(a), (x, y) -> (x.big(y) ? 1 : -1));
        for(int i=0;i<n;i++) System.out.println(a[i]);
        sc.close();
    }
}
