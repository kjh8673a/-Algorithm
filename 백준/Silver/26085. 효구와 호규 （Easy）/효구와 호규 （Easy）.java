import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        if (zero % 2 == 1 || one % 2 == 1) {
            System.out.println(-1);
        } else {
            System.out.println(isPossible());
        }

    }

    private static int isPossible() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int node = board[i][j];

                for (int k = 0; k < 4; k++) {
                    int nr = i + vector[k][0];
                    int nc = j + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        continue;
                    }

                    if (board[nr][nc] == node) {
                        return 1;
                    }
                }
            }
        }

        return -1;
    }

}