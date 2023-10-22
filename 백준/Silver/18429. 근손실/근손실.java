import java.util.*;
import java.io.*;

public class Main {
    static int N, K, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(0, 0, 500);

        System.out.println(ans);
    }

    private static void dfs(int day, int visit, int weight) {
        if (day == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && weight + arr[i] - K >= 500) {
                dfs(day + 1, visit + (1 << i), weight + arr[i] - K);
            }
        }
    }

}
