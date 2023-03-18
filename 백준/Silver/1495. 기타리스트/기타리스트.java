import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] check = new boolean[N][M + 1];
        if (S - arr[0] >= 0) {
            check[0][S - arr[0]] = true;
        }
        if (S + arr[0] <= M) {
            check[0][S + arr[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (check[i - 1][j]) {
                    if (j - arr[i] >= 0) {
                        check[i][j - arr[i]] = true;
                    }
                    if (j + arr[i] <= M) {
                        check[i][j + arr[i]] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = M; i >= 0; i--) {
            if (check[N - 1][i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}