import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + board[i - 1][j] + board[i][j - 1]
                        - board[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int rs = 1; rs < n + 1; rs++) {
            for (int cs = 1; cs < m + 1; cs++) {
                for (int re = rs; re < n + 1; re++) {
                    for (int ce = cs; ce < m + 1; ce++) {
                        ans = Math.max(ans,
                                board[re][ce] - board[rs - 1][ce] - board[re][cs - 1] + board[rs - 1][cs - 1]);
                    }
                }
            }
        }

        System.out.println(ans);
    }

}