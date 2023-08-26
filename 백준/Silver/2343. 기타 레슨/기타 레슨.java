import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        System.out.println(binarySearch(left, right));
    }

    private static int binarySearch(int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                cnt++;
            }

            if (cnt <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}