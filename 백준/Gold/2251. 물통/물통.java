import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static boolean[][][] visit;
    static TreeSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[C + 1][C + 1][C + 1];
        set = new TreeSet<>();
        dfs(0, 0, C);

        StringBuilder sb = new StringBuilder();
        set.stream().forEach(num -> sb.append(num + " "));

        System.out.println(sb);
    }

    private static void dfs(int a, int b, int c) {
        if (visit[a][b][c]) {
            return;
        }

        if (a == 0) {
            set.add(c);
        }

        visit[a][b][c] = true;

        if (a > 0) {
            if (a + b > B) {
                dfs(a + b - B, B, c);
            } else {
                dfs(0, a + b, c);
            }

            if (a + c > C) {
                dfs(a + c - C, b, c);
            } else {
                dfs(0, b, a + c);
            }
        }

        if (b > 0) {
            if (b + c > C) {
                dfs(a, b + c - C, C);
            } else {
                dfs(a, 0, b + c);
            }

            if (b + a > A) {
                dfs(A, b + a - A, c);
            } else {
                dfs(b + a, 0, c);
            }
        }

        if (c > 0) {
            if (c + a > A) {
                dfs(A, b, c + a - A);
            } else {
                dfs(c + a, b, 0);
            }

            if (c + b > B) {
                dfs(a, B, c + b - B);
            } else {
                dfs(a, c + b, 0);
            }
        }
    }

}
