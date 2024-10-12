import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (pq.peek() >= h && t > count && pq.peek() > 1) {
            int tall = pq.poll();
            pq.add(tall / 2);
            count++;
        }

        if (pq.peek() >= h) {
            System.out.println("NO");
            System.out.println(pq.peek());
        } else {
            System.out.println("YES");
            System.out.println(count);
        }
    }

}
