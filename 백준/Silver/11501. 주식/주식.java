import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            long sum = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < max) {
                    sum += (max - arr[i]);
                } else {
                    max = arr[i];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}
