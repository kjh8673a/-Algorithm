import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int[][] dp = new int[r][c];
        dp[0][0] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }

                for (int k = i + 1; k < r; k++) {
                    for (int l = j + 1; l < c; l++) {
                        if (board[k][l] != board[i][j]) {
                            dp[k][l] += dp[i][j];
                        }
                    }
                }
            }
        }

        System.out.println(dp[r - 1][c - 1]);
    }
}