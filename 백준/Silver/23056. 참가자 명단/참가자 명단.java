import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    private static Ban[] blueTeam;
    private static Ban[] whiteTeam;

    static class Ban {
        private int banNumber;
        private List<Student> students;
        public Ban(int banNumber) {
            this.banNumber = banNumber;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            if (this.students.size() >= M) {
                return;
            }

            this.students.add(student);
        }

        public void sortStudents() {
            Collections.sort(this.students, (o1, o2) -> {
                if (o1.name.length() == o2.name.length()) {
                    return o1.name.compareTo(o2.name);
                }

                return o1.name.length() - o2.name.length();
            });
        }
    }

    static class Student {
        private String name;
        public Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        blueTeam = new Ban[N / 2 + 1];
        whiteTeam = new Ban[N / 2 + 1];

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                // 청팀 초기화
                blueTeam[i / 2 + 1] = new Ban(i);
            } else {
                // 백팀 초기화
                whiteTeam[i / 2] = new Ban(i);
            }
        }

        M = Integer.parseInt(st.nextToken());

        while (true) {
            st = new StringTokenizer(br.readLine());

            int ban = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (ban == 0) {
                break;
            }

            // 청팀
            if (ban % 2 == 1) {
                blueTeam[ban / 2 + 1].addStudent(new Student(name));
            }
            else {
                whiteTeam[ban / 2].addStudent(new Student(name));
            }
        }

        // 청팀 출력
        for (int i = 1; i <= N / 2; i++) {
            blueTeam[i].sortStudents();
            for (Student student : blueTeam[i].students) {
                sb.append(blueTeam[i].banNumber).append(" ").append(student.name).append("\n");
            }
        }

        // 백팀 출력
        for (int i = 1; i <= N / 2; i++) {
            whiteTeam[i].sortStudents();
            for (Student student : whiteTeam[i].students) {
                sb.append(whiteTeam[i].banNumber).append(" ").append(student.name).append("\n");
            }
        }

        System.out.println(sb);
    }
}