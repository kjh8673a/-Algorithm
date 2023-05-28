import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        long[] forward = new long[N];
        long[] dp_forward = new long[N];
        forward[0] = dp_forward[0] = Math.max(arr[0], 0);
        for (int i = 1; i < N; i++) {
            forward[i] = Math.max(forward[i - 1] + arr[i], arr[i]);
            dp_forward[i] = Math.max(dp_forward[i - 1], forward[i]);
        }

        long[] reverse = new long[N];
        long[] dp_reverse = new long[N];
        reverse[N - 1] = dp_reverse[N - 1] = Math.max(arr[N - 1], 0);
        for (int i = N - 2; i >= 0; i--) {
            reverse[i] = Math.max(reverse[i + 1] + arr[i], arr[i]);
            dp_reverse[i] = Math.max(dp_reverse[i + 1], reverse[i]);
        }

        long max = 0;
        for (int i = 0; i < N - 1; i++) {
            max = Math.max(dp_forward[i] + dp_reverse[i + 1], max);
        }

        long ans = sum + max;
        System.out.println(ans);
    }

}