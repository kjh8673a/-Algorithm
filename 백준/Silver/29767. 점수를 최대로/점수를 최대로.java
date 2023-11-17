import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                arr[i] += arr[i - 1];
            }
        }
        Arrays.sort(arr);

        long ans = 0;
        for (int i = 1; i < K + 1; i++) {
            ans += arr[N - i];
        }

        System.out.println(ans);
    }

}