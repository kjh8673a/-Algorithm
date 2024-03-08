import java.io.*;
import java.util.*;

public class Main {
    static class Score {
        String name;
        int korean;
        int english;
        int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Score[] students = new Score[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students[i] = new Score(name, korean, english, math);
        }

        Arrays.sort(students, (o1, o2) -> {
            if (o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math) {
                return o1.name.compareTo(o2.name);
            } else if (o1.korean == o2.korean && o1.english == o2.english) {
                return Integer.compare(o2.math, o1.math);
            } else if (o1.korean == o2.korean) {
                return Integer.compare(o1.english, o2.english);
            }
            return Integer.compare(o2.korean, o1.korean);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(students[i].name).append("\n");
        }

        System.out.println(sb.toString());
    }

}