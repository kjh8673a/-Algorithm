import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = {
            { 0, 4, 3, 3, 4, 3, 2, 3, 1, 2 },
            { 4, 0, 5, 3, 2, 5, 6, 1, 5, 4 },
            { 3, 5, 0, 2, 5, 4, 3, 4, 2, 3 },
            { 3, 3, 2, 0, 3, 2, 3, 2, 2, 1 },
            { 4, 2, 5, 3, 0, 3, 4, 3, 3, 2 },
            { 3, 5, 4, 2, 3, 0, 1, 4, 2, 1 },
            { 2, 6, 3, 3, 4, 1, 0, 5, 1, 2 },
            { 3, 1, 4, 2, 3, 4, 5, 0, 4, 3 },
            { 1, 5, 2, 2, 3, 2, 1, 4, 0, 1 },
            { 2, 4, 3, 1, 2, 1, 2, 3, 1, 0 }
    };

    static int N, K, P, X, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        result = 0;
        solve(0, 0, 0);

        System.out.println(result - 1);
    }

    private static void solve(int idx, int sum, int cnt) {
        if (cnt > P || sum > N) {
            return;
        }

        if (idx == K) {
            if (sum != 0) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            solve(idx + 1, sum + i * (int) Math.pow(10, idx), cnt + arr[X / (int) Math.pow(10, idx) % 10][i]);
        }
    }

}
