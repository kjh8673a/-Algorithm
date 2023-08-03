import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                dp[j][i + j] = Integer.MAX_VALUE;

                for (int k = j; k < i + j; k++) {
                    dp[j][i + j] = Math.min(dp[j][i + j],
                            dp[j][k] + dp[k + 1][i + j] + matrix[j][0] * matrix[k][1] * matrix[i + j][1]);
                }
            }
        }

        System.out.println(dp[0][N - 1]);

    }

}