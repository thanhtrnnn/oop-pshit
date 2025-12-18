import java.util.*;
import java.io.*;
import java.math.*;

public class bai3_danhsachphim {
    private static final Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    // LonggVuz
    public static String edit(String a){
        String s = "";
        String[] t = a.toLowerCase().trim().split("\\s+");
        for(String i : t){
            s += i.substring(0, 1).toUpperCase() + i.substring(1);
            s += " ";
        }
        return s.trim();
    }

    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> mp = new HashMap<>();
        for(int i=1; i<=n; i++){
            String tl = "TL" + String.format("%03d", i);
            mp.put(tl, sc.nextLine());
        }
        phim[] a = new phim[m + 5];
        for(int i=1; i<=m; i++){
            String ma = "P" + String.format("%03d", i);
            String tl = sc.nextLine();
            tl = mp.get(tl);
            String date = sc.nextLine();
            String name = sc.nextLine();
            int cnt = sc.nextInt(); sc.nextLine();
            a[i] = new phim(ma, tl, date, name, cnt);
        }
        Arrays.sort(a, 1, m + 1, Comparator.comparing(phim::nam)
            .thenComparing(phim::thang)
            .thenComparing(phim::ngay)
            .thenComparing(phim::ten)
            .thenComparing(Comparator.comparing(phim::tap).reversed()));
        for(int i=1; i<=m; i++){
            System.out.println(a[i]);
        }

    }
}

class phim{
    private String ma, tl, date, name;
    private int cnt;
    public phim(String ma, String tl, String date, String name, int cnt){
        this.ma = ma;
        this.tl = tl;
        this.date = edit(date);
        this.name = name;
        this.cnt = cnt;
    }
    public String edit(String date){
        // d/m/yyyy
        if(date.charAt(1) == '/') date = "0" + date;
        // dd/m/yyyy
        // 012345678
        if(date.charAt(4) == '/') date = date.substring(0, 3) + "0" + date.substring(3);
        return date;
    }
    public String ten(){
        return name;
    }
    public int nam(){
        String[] a = date.split("/");
        return Integer.parseInt(a[2]);
    }
    public int thang(){
        String[] a = date.split("/");
        return Integer.parseInt(a[1]);
    }
    public int ngay(){
        String[] a = date.split("/");
        return Integer.parseInt(a[0]);
    }
    public int tap(){
        return cnt;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s %s %d", ma, tl, date, name, cnt);
    }
}