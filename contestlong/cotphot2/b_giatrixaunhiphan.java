import java.io.*;
import java.util.*;

public class b_giatrixaunhiphan {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        // }
        
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DATA.in")));
        @SuppressWarnings("unchecked")
        ArrayList<String> a = (ArrayList<String>) ois.readObject();
        ois.close();

        for (String s : a) {
            String bin = "";
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c == '0' || c == '1')
                    bin += c;
            }
            if (bin.length() == 0) continue;
            long val = Long.parseLong(bin, 2);
            System.out.println(bin + " " + val);
        }
    }
}