import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[s];
        int left = 1;
        int right = 0;
        long sum = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
            sum += arr[i];
        }

        long max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 0; i < s; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= c) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(sum - max * c);
    }

}