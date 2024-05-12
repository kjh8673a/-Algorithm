import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer>[] queues = new Queue[21];
        for (int i = 0; i < 21; i++) {
            queues[i] = new LinkedList<>();
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int len = name.length();

            while (!queues[len].isEmpty() && queues[len].peek() < i - k) {
                queues[len].poll();
            }
            answer += queues[len].size();

            queues[len].add(i);
        }

        System.out.println(answer);
    }

}
