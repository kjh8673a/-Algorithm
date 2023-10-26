import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int weight;
        int time;

        public Node(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> queue = new LinkedList<>();
        int time = 1;
        int sum = 0;
        int idx = 1;
        queue.add(new Node(truck[0], w + 1));
        sum += truck[0];
        while (!queue.isEmpty()) {
            time++;
            if (queue.peek().time == time) {
                sum -= queue.peek().weight;
                queue.poll();
            }

            if (idx < n && sum + truck[idx] <= L) {
                queue.add(new Node(truck[idx], time + w));
                sum += truck[idx++];
            }
        }

        System.out.println(time);
    }

}
