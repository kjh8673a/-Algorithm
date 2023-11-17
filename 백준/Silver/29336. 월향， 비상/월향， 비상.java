import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;
        int T = 0;
        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            while (!pq.isEmpty() && sum < Q) {
                sum += pq.poll() + T;
            }

            if (sum < Q) {
                flag = false;
            }
        }
        while (!pq.isEmpty()) {
            sum += pq.poll() + T;
        }

        if (!flag) {
            sum = -1;
        }

        System.out.println(sum);
    }

}