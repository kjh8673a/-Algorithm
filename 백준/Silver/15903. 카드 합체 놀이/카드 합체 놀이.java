import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long a = pq.poll() + pq.poll();
            pq.add(a);
            pq.add(a);
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);

    }
}
