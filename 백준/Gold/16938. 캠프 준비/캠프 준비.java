import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        boolean[] visit;
        for (int i = 1; i < (1 << N); i++) {
            visit = new boolean[N];
            int len = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    visit[j] = true;
                    len++;
                }
            }
            if (len == 1) {
                continue;
            }
            if (check(visit)) {
                ans++;
            }
        }

        System.out.println(ans);

    }

    private static boolean check(boolean[] visit) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                continue;
            }

            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
            sum += arr[i];
        }

        if (sum < L || sum > R) {
            return false;
        }

        if (max - min < X) {
            return false;
        }

        return true;
    }

}