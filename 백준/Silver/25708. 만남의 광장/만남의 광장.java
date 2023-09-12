import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] rowSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += board[i][j];
            }
        }

        int[] colSum = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colSum[j] += board[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int up = 0; up < n; up++) {
            for (int down = up + 1; down < n; down++) {
                for (int left = 0; left < m; left++) {
                    for (int right = left + 1; right < m; right++) {
                        int sum = rowSum[up] + rowSum[down] + colSum[left] + colSum[right];
                        sum -= (board[up][left] + board[up][right] + board[down][left] + board[down][right]);
                        sum += (down - up - 1) * (right - left - 1);

                        ans = Math.max(ans, sum);
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
