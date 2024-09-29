import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            d += 360;
            d %= 360;

            int[][] x = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    x[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < d / 45; i++) {
                x = rotate(x);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(x[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int[][] rotate(int[][] x) {
        int n = x.length;
        int[][] result = new int[n][n];

        // X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열 ((n+1)/2 번째 열)로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][n / 2] = x[i][i];
        }

        // X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][(n - 1) - i] = x[i][n / 2];
        }

        // X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[n / 2][(n - 1) - i] = x[i][(n - 1) - i];
        }

        // X의 가운데 행을 X의 주 대각선으로 옮긴다.
        for (int i = 0; i < n; i++) {
            result[i][i] = x[n / 2][i];
        }

        // X의 다른 원소의 위치는 변하지 않는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = x[i][j];
                }
            }
        }

        return result;
    }

}