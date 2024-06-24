import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] left = new int[n];
        for (int i = 1; i < n; i += 2) {
            left[i] += (arr[i] - arr[i - 1]);
            if (i - 2 >= 0) {
                left[i] += left[i - 2];
            }
        }

        int[] right = new int[n];
        for (int i = n - 2; i > 0; i -= 2) {
            right[i] += (arr[i + 1] - arr[i]);
            if (i + 2 < n) {
                right[i] += right[i + 2];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i += 2) {
            int tmp = (arr[i + 2] - arr[i]);
            if (i - 1 >= 0) {
                tmp += left[i - 1];
            }
            if (i + 3 < n) {
                tmp += right[i + 3];
            }
            answer = Math.min(tmp, answer);
        }

        System.out.println(answer);
    }
}