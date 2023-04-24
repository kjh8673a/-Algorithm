import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            int left = i;
            int right = i + 17;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (left <= arr[j] && arr[j] <= right) {
                    continue;
                }

                int diff = 0;
                if (arr[j] < left) {
                    diff = left - arr[j];
                    sum += diff * diff;
                } else if (arr[j] > right) {
                    diff = arr[j] - right;
                    sum += diff * diff;
                }
            }
            ans = Math.min(sum, ans);
        }

        System.out.println(ans);
    }

}