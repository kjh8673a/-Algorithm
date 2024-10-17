import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            sum[i] = 1;
            sum[i] *= arr[i];
            sum[i] *= arr[(i + 1) % N];
            sum[i] *= arr[(i + 2) % N];
            sum[i] *= arr[(i + 3) % N];

            total += sum[i];
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(st.nextToken()) - 1;
            for (int j = q; j > q - 4; j--) {
                sum[(j + N) % N] *= -1;
                total += (2 * sum[(j + N) % N]);
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}