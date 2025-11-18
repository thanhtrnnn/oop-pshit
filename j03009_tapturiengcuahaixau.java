import java.io.*;
import java.util.*;

public class j03009_tapturiengcuahaixau {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t-=1;
            Set<String> st = new HashSet<>();
            String s1[] = sc.nextLine().split("\\s");
            String s2 = sc.nextLine();
            for(String word: s1){
                if(!s2.contains(word)){
                    st.add(word);
                }
            }
            for(String i: st){
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
    
}
