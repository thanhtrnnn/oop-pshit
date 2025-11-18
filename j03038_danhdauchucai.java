import java.util.*;
import java.io.*;

public class j03038_danhdauchucai {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Set<Character> st = new HashSet<>();
        for(int i=0;i<s.length();i++){
            st.add(s.charAt(i));
        }
        System.out.println(st.size());
        
    }
    
}
