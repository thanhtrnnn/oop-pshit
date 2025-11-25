import java.io.*;
import java.util.*;

public class c4_baocaothuctapcoso {
    static class student {
        String id, name, project, advisor;

        public student(String id, String name, String project, String advisor) {
            this.id = id;
            this.name = name;
            this.project = project;
            this.advisor = advisor;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + project + " " + advisor;
        }
    }

    static class project {
        String id, teacher, title;

        public project(int id, String teacher, String title) {
            this.id = String.format("DT%03d", id);
            this.teacher = teacher;
            this.title = title;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sv = new Scanner(new File("SINHVIEN.in"));
        Scanner dt = new Scanner(new File("DETAI.in"));
        Scanner hd = new Scanner(new File("HOIDONG.in"));

        int t = Integer.parseInt(sv.nextLine());
        ArrayList<student> svs = new ArrayList<>();
        ArrayList<project> dts = new ArrayList<>();
        HashMap<String, String> svToBoard = new HashMap<>();
        for (int i = 0; i < t; i++) {
            svs.add(new student(sv.nextLine(), sv.nextLine(), sv.nextLine(), sv.nextLine()));
        }
        t = Integer.parseInt(dt.nextLine());
        for (int i = 0; i < t; i++) {
            dts.add(new project(i + 1, dt.nextLine(), dt.nextLine()));
        }
        t = Integer.parseInt(hd.nextLine());
        for (int i = 0; i < t; i++) {
            String[] parts = hd.nextLine().split(" ");
            svToBoard.put(parts[0], parts[2]);
        }

        for (student s : svs) {
            String board = svToBoard.get(s.id);
            String projectTitle = "", advisorName = board;
            for (project p : dts) {
                if (p.id.equals(s.project)) {
                    projectTitle = p.title;
                    break;
                }
            }
            System.out.println("DANH SACH HOI DONG " + board + ":");
            System.out.println(s.id + " " + s.name + " " + projectTitle + " " + advisorName);
        }
        sv.close();
        dt.close();
        hd.close();
    }
}