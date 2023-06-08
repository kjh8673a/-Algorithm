import java.io.*;
import java.util.*;

public class Main {
    static int N, M, len, ans;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        len = 0;
        ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void find(int r, int c) {
        int num = board[r][c];
        int tmp = len > 0 ? len : 1;
        while (true) {
            if (r + tmp >= N || c + tmp >= M) {
                break;
            }

            if (board[r + tmp][c + tmp] == num && board[r][c + tmp] == num && board[r + tmp][c] == num) {
                len = tmp;
                ans = (tmp + 1) * (tmp + 1);
            }
            tmp++;
        }
    }

}
