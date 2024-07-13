import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    dist[i][j] = 100000000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int a = 0;
        int b = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int tmp = makeSum(i, j);
                if (sum > tmp) {
                    sum = tmp;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(a + " " + b + " " + (sum * 2));
    }

    private static int makeSum(int a, int b) {
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i == a || i == b) {
                continue;
            }

            result += Math.min(dist[i][a], dist[i][b]);
        }

        return result;
    }

}