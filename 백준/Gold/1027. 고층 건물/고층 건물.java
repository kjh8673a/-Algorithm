import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static double[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(seeLeft(i) + seeRight(i), ans);
        }

        System.out.println(ans);
    }

    public static int seeLeft(int idx) {
        if (idx == 0) {
            return 0;
        }

        int cnt = 1;
        int left = idx - 1;
        double slope = (arr[left] - arr[idx]);

        while (left-- > 0) {
            double tmp = (arr[left] - arr[idx]) / (idx - left);
            if (tmp > slope) {
                cnt++;
                slope = tmp;
            }
        }

        return cnt;

    }

    public static int seeRight(int idx) {
        if (idx == N - 1) {
            return 0;
        }

        int cnt = 1;
        int right = idx + 1;
        double slope = (arr[right] - arr[idx]);
        while (right++ < N - 1) {
            double tmp = (arr[right] - arr[idx]) / (right - idx);
            if (tmp > slope) {
                cnt++;
                slope = tmp;
            }
        }

        return cnt;
    }

}
