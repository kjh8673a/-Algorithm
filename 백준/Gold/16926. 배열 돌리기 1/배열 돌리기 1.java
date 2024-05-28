import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(n, m) / 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < cnt; j++) {
                int tmp = arr[j][j];

                for (int k = j; k < m - j - 1; k++) {
                    arr[j][k] = arr[j][k + 1];
                }

                for (int k = j; k < n - j - 1; k++) {
                    arr[k][m - j - 1] = arr[k + 1][m - j - 1];
                }

                for (int k = m - j - 1; k > j; k--) {
                    arr[n - j - 1][k] = arr[n - 1 - j][k - 1];
                }

                for (int k = n - j - 1; k > j; k--) {
                    arr[k][j] = arr[k - 1][j];
                }

                arr[j + 1][j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}