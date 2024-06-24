import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int start = queue.poll();
            int count = 0;
            while (count < k - 1 && queue.size() > 0) {
                queue.poll();
                count++;
            }
            queue.add(start);
        }

        System.out.println(queue.poll());
    }
}