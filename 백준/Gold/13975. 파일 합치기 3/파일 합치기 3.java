import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while (pq.size() > 1) {
                long tmp = pq.poll() + pq.poll();
                answer += tmp;
                pq.add(tmp);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}