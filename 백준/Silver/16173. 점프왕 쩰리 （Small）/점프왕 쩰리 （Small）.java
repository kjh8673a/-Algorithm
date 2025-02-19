import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        flag = false;

        dfs(0, 0);

        System.out.println(flag ? "HaruHaru" : "Hing");
    }

    private static void dfs(int i, int j) {
        if (i >= n || j >= n || flag || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        if (board[i][j] == -1) {
            flag = true;
            return;
        }

        dfs(i + board[i][j], j);
        dfs(i, j + board[i][j]);
    }

}