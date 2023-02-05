import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt) {
                return Integer.compare(o.cnt, this.cnt);
            } else if (this.cnt == o.cnt && o.word.length() != this.word.length()) {
                return Integer.compare(o.word.length(), this.word.length());
            } else {
                return this.word.compareTo(o.word);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (String key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }
        System.out.println(sb.toString());

    }

}