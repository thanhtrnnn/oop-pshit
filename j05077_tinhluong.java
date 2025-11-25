import java.io.*;
import java.util.*;

public class j05077_tinhluong {
    static class Employee {
        String id, name, dept;
        int heso, days;
        Long base, salary;

        public Employee(String id, String name, String dept, Long base, int days) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.base = base;
            this.days = days;
            calc();
            this.salary = this.heso * base * days * 1000;
        }

        private void calc() {
            char group = id.charAt(0);
            int years = Integer.parseInt(id.substring(1, 3));
            if (group == 'A') {
                this.heso = (years >= 16) ? 20 : (years >= 9) ? 14 : (years >= 4) ? 12 : 10;
            } else if (group == 'B') {
                this.heso = (years >= 16) ? 16 : (years >= 9) ? 13 : (years >= 4) ? 11 : 10;
            } else if (group == 'C') {
                this.heso = (years >= 16) ? 14 : (years >= 9) ? 12 : (years >= 4) ? 10 : 9;
            } else {
                this.heso = (years >= 16) ? 13 : (years >= 9) ? 11 : (years >= 4) ? 9 : 8;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + dept + " " + salary;
        }
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        TreeMap<String, String> dept = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            dept.put(line.substring(0, 2), line.substring(3).trim());
        }

        int n = sc.nextInt();
        ArrayList<Employee> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String id = sc.nextLine();
            a.add(new Employee(id, sc.nextLine(), dept.get(id.substring(3)), sc.nextLong(), sc.nextInt()));
        }
        a.forEach(System.out::println);
        sc.close();
    }
}