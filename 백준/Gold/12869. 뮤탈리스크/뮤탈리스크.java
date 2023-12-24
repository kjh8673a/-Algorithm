import java.io.*;
import java.util.*;

public class Main {
    static int[][][] visited;
    static int answer;
    static int[][] vector = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        visited = new int[61][61][61];
        answer = Integer.MAX_VALUE;
        dfs(scv, 0);

        System.out.println(answer);
    }

    private static void dfs(int[] scv, int cnt) {
        int a = Math.max(0, scv[0]);
        int b = Math.max(0, scv[1]);
        int c = Math.max(0, scv[2]);

        if (cnt >= answer) {
            return;
        }

        if (a == 0 && b == 0 && c == 0) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (visited[a][b][c] != 0 && visited[a][b][c] <= cnt) {
            return;
        }
        visited[a][b][c] = cnt;

        for (int i = 0; i < 6; i++) {
            dfs(new int[] { a - vector[i][0], b - vector[i][1], c - vector[i][2] }, cnt + 1);
        }
    }

}