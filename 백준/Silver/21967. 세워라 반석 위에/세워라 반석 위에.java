import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[11];
        int left = 0;
        int right = 0;
        int max = 1;
        count[arr[0]]++;
        while (left <= N - 1) {
            boolean flag = check();
            if (flag) {
                max = Math.max(max, right - left + 1);
            }
            if (right == N - 1) {
                count[arr[left++]]--;
            } else if (flag || left == right) {
                count[arr[++right]]++;
            } else {
                count[arr[left++]]--;
            }
        }
        System.out.println(max);
    }

    static boolean check() {
        int left = -1;
        int right = -1;
        for (int i = 1; i <= 10; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (left == -1) {
                left = i;
            }
            right = i;
        }
        if (right - left <= 2) {
            return true;
        } else {
            return false;
        }
    }
}
