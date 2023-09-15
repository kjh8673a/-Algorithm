import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean check(int mid) {
        int prev = 0;

        for (int i = 0; i < M; i++) {
            if (arr[i] - mid <= prev) {
                prev = arr[i] + mid;
            } else {
                return false;
            }
        }

        return prev >= N;
    }

}
