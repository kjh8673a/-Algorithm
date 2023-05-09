import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        char ch;
        int val;

        public Node(char ch, int val) {
            this.ch = ch;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, arr[i].length() - j - 1));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        int num = 9;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < N; i++) {
                arr[i] = arr[i].replace(node.ch, (char) (num + '0'));
            }
            num--;
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);

    }
}
