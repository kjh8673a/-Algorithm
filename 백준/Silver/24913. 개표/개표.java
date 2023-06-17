import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] vote = new long[N + 2];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                vote[c] += b;
            } else {
                long max = 0;
                long sum = 0;
                for (int j = 1; j < N + 1; j++) {
                    max = Math.max(max, vote[j]);
                    sum += vote[j];
                }
                long everage = (sum + c) / N;
                if ((sum + c) % N != 0) {
                    everage += 1;
                }

                if (vote[N + 1] + b <= max) {
                    sb.append("NO").append("\n");
                } else if (vote[N + 1] + b <= everage) {
                    sb.append("NO").append("\n");
                } else {
                    sb.append("YES").append("\n");
                }

            }
        }

        System.out.println(sb);

    }

}
