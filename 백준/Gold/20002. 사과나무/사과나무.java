import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                board[i][j] = board[i - 1][j] + board[i][j - 1] + Integer.parseInt(st.nextToken())
                        - board[i - 1][j - 1];
            }
        }

        int ans = board[1][1];
        int size = 0;
        while (size++ < N) {
            for (int i = size; i < N + 1; i++) {
                for (int j = size; j < N + 1; j++) {
                    int sum = board[i][j] - board[i - size][j] - board[i][j - size] + board[i - size][j - size];
                    ans = Math.max(sum, ans);
                }
            }
        }

        System.out.println(ans);
    }

}
