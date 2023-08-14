import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long max = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Integer.parseInt(st.nextToken());
            if (num > max) {
                max = num;
            }
            pq.add(num);
        }

        long tmp = max;
        long ans = tmp - pq.peek();
        while (pq.peek() < max) {
            long min = pq.poll();
            ans = Math.min(tmp - min, ans);
            tmp = Math.max(max, min * 2);
            pq.add(min * 2);
        }

        System.out.println(Math.min(tmp - pq.peek(), ans));
    }

}