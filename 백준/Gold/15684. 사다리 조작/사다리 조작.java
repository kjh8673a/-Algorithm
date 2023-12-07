import java.io.*;
import java.util.*;

public class Main {
    static int N, H, ans;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[a][b + 1] = -1;
        }

        ans = -1;
        for (int i = 0; i < 4; i++) {
            if (ans != -1) {
                break;
            }
            putLadder(0, i);
        }

        System.out.println(ans);
    }

    private static void putLadder(int now, int cnt) {
        if (now == cnt) {
            if (ans == -1) {
                play(cnt);
            }
            return;
        }

        for (int i = 1; i < H + 1; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] != 0 || board[i][j + 1] != 0) {
                    continue;
                }
                board[i][j] = 1;
                board[i][j + 1] = -1;
                putLadder(now + 1, cnt);
                board[i][j] = 0;
                board[i][j + 1] = 0;
            }
        }
    }

    private static void play(int cnt) {
        for (int i = 1; i < N + 1; i++) {
            int c = i;
            for (int j = 1; j < H + 1; j++) {
                c += board[j][c];
            }
            if (c != i) {
                return;
            }
        }

        ans = cnt;
    }

}
