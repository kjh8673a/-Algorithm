import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] += arr[i] + sum[i - 1];
        }

        long answer = 0;
        for (int i = 1; i < n; i++) {
            answer += arr[i] * (sum[n] - sum[i]);
            answer %= MOD;
        }

        System.out.println(answer);
    }

}