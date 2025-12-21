import java.io.*;
import java.util.*;

public class c_icpcquocgia {
    static class Team {
        private String name, uni;
        private int id;

        public Team(String name, String uni) {
            // this.id = String.format("team%02d", i);
            this.name = name;
            this.uni = uni;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("team%02d", id) + " " + name + " " + uni;
        }
        
    }
    public static void main(String[] args) throws IOException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        // }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Team> a = new ArrayList<>();
        HashMap<String, String> abbr = new HashMap<>();
        for (int i = 0; i < t; i++) {
            String line[] = sc.nextLine().split(" ");
            String uniName = "";
            for (int j = 1; j < line.length; j++)
                uniName += line[j] + " ";
            abbr.put(line[0], uniName);
        }
        
        t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            String ma = sc.next();
            int k = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < k; j++) {
                String name = sc.nextLine();
                a.add(new Team(name, abbr.get(ma)));
            }
        }
        a.sort((o1, o2) -> { return (o1.name.equals(o2.name)) ? o1.uni.compareTo(o2.uni): o1.name.compareTo(o2.name); });
        for (Team team : a) {
            team.setId(a.indexOf(team) + 1);
        }
        a.forEach(System.out::println);
        sc.close();
    }
}