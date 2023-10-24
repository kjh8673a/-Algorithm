import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long l = 0;
        long r = (long) arr[N - 1] * M;

        long ans = 0;
        long mid;
        while (l <= r) {
            mid = (l + r) / 2;

            long tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += mid / arr[i];
            }

            if (tmp < M) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }

}
