import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > dp[max]) {
                dp[++max] = arr[i];
            } else {
                int idx = binarySearch(dp, 0, max, arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(max);
    }

    private static int binarySearch(int[] arr, int left, int right, int key) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
