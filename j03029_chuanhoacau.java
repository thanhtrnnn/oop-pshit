import java.util.*;
import java.io.*;

public class j03029_chuanhoacau {
    static String marks = ".!?";
    static void process(String s){
        if(s.length() == 0) 
            return;
        if(marks.indexOf(s.charAt(s.length()-1)) == -1){
            s += ".";
        }
        String a[] = s.split("\\s+");
        int n = a.length;
        if(a[a.length - 1].length() == 1 && marks.contains(a[a.length - 1])){
            if(a.length>1){
                n-=1;
                a[a.length - 2] += a[a.length - 1];
            }
        }
        int i=0;
        while(i<n){
            a[i] = Character.toString(a[i].charAt(0)).toUpperCase() 
                + a[i].substring(1);

            while(marks.indexOf(a[i].charAt(a[i].length()-1)) == -1){
                System.out.printf("%s ", a[i]);
                i++;
            }

            System.out.printf("%s ", a[i]);
            i++;
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            process(sc.nextLine().toLowerCase().trim());
        }
    }
}
