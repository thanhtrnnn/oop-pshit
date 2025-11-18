import java.io.*;
import java.util.*;

/**
 *
 * @author admin
 */
class ThiSinh{
    private String maTS, hoTen, danToc, khuVuc;
    private float diemThi;
    private static int id = 1;
    public ThiSinh(String hoTen, String danToc, String khuVuc, float diemThi) {
        this.maTS = "TS" + String.format("%02d", id++);
        this.hoTen = hoTen;
        this.danToc = danToc;
        this.khuVuc = khuVuc;
        this.diemThi = diemThi;
    }
    public String getMaTS(){
        return this.maTS;
    }

    public void chuanHoaTen(){
        String[] n = this.hoTen.toLowerCase().split("\\s+");
        String r = "";
        for(int i=0; i<n.length; i++){
            if(n[i].length() == 0) continue;
            r += Character.toString(n[i].charAt(0)).toUpperCase() + n[i].substring(1) + " ";
        }
        this.hoTen = r;
    }

    public float diemUuTien(){
        float diem = 0;
        if("1".equals(this.khuVuc)) diem += 1.5;
        else if("2".equals(this.khuVuc)) diem += 1;
        if(!"Kinh".equals(this.danToc)) diem += 1.5;
        return diem;
    }

    public float tongDiem(){
        return this.diemThi + this.diemUuTien();
    }
    public String trangThai(){
        return this.tongDiem() >= 20.5 ? "Do" : "Truot";
    }
    
    @Override
    public String toString(){
        return this.maTS + " " + this.hoTen + " " + String.format("%.1f", this.tongDiem()) + " " + this.trangThai();
    }
}
public class j07057_diemtuyensinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = sc.nextInt();
        ArrayList<ThiSinh> list = new ArrayList<>();
        while(n-- > 0){
            sc.nextLine();
            String hoTen = sc.nextLine();
            float diemThi = sc.nextFloat();
            sc.nextLine();
            String danToc = sc.nextLine();
            String khuVuc = sc.next();
            ThiSinh ts = new ThiSinh(hoTen, danToc, khuVuc, diemThi);
            ts.chuanHoaTen();
            list.add(ts);
        }
        Collections.sort(list, new Comparator<ThiSinh>(){
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                // if(o2.tongDiem() == o1.tongDiem())
                //     return o1.getMaTS().compareTo(o2.getMaTS());
                // if(o1.tongDiem() < o2.tongDiem())
                //     return 1;
                // return -1;
                if(o2.tongDiem() != o1.tongDiem())
                    return Float.compare(o2.tongDiem(), o1.tongDiem());
                return o1.getMaTS().compareTo(o2.getMaTS());
            }
        });
        for(ThiSinh x : list){
            System.out.println(x);
        }
        sc.close();
    }
}
