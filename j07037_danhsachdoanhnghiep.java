import java.io.*;
import java.util.*;

public class j07037_danhsachdoanhnghiep {
    static class student{
        String code, name, method, mail;
        public student(String c, String n, String m){
            code=c;
            name=n;
            method=m;
        }
        public boolean big(student b){
            if(code.compareTo(b.code) > 0) return true;
            return false;
        }
        public String toString(){
            return code + " " + name + " " + method;
        }
    }
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(new File("DN.in"));
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        student[] a = new student[n];
        sc.nextLine();
        for(int i=0; i<n; i++){
            a[i] = new student(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(a, (x, y) -> x.big(y) ? 1 : -1);
        for(int i=0;i<n;i++) System.out.println(a[i]);
        sc.close();
    }
}
