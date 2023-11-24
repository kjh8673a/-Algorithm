import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1;
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            left = Math.max(money[i], left);
            right += money[i];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += money[i];
                if (sum > mid) {
                    sum = money[i];
                    cnt++;
                }
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}