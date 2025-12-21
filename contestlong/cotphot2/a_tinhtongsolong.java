import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class a_tinhtongsolong {
    public static void main(String[] args) throws IOException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        // }

        File x = new File("DATA.in");
        try {
            BigInteger s = BigInteger.ZERO;
            Scanner sc = new Scanner(x);
            while (sc.hasNext()){
                try {
                    String t = sc.next();
                    long pot = Long.parseLong(t);
                    if (pot > Integer.MAX_VALUE) {
                        s = s.add(new BigInteger(t));
                    }
                } catch(NumberFormatException e){}
            }
            System.out.println(s);
            sc.close();
        } catch(FileNotFoundException e){}
    }
}