package B23DCAT280;

import java.io.*;
import java.util.*;

public class bai2 {
    static class person {
        String name, sdt, date;

        public person(String name, String sdt, String date) {
            this.name = name;
            this.sdt = sdt;
            this.date = date;
        }
        
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream(outputFile));
        }
        Scanner sc = new Scanner(System.in);
        String date = "";
        
        ArrayList<person> a = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.startsWith("Ngay")) {
                String[] tmp = line.split("\\s+");
                if (tmp.length >= 2) date = tmp[1];
                else {
                    String ten = line;
                     
                }
            }
            
        }
        sc.close();
    }
}