import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer>[] lines = new Stack[n + 1];
        for (int i = 1; i < n + 1; i++) {
            lines[i] = new Stack<>();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (lines[a].isEmpty()) {
                lines[a].add(b);
                answer++;
            } else {
                while (!lines[a].isEmpty() && lines[a].peek() > b) {
                    lines[a].pop();
                    answer++;
                }
                if (lines[a].isEmpty() || lines[a].peek() < b) {
                    lines[a].add(b);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}