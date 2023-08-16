import java.io.*;

public class Main {
    static int N, k;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        ans = binarySearch(1, k);

        System.out.println(ans);
    }

    private static long binarySearch(long left, long right) {
        if (left >= right) {
            return left;
        }

        long mid = (left + right) / 2;

        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(mid / i, N);
        }

        if (cnt >= k) {
            return binarySearch(left, mid);
        } else {
            return binarySearch(mid + 1, right);
        }

    }

}