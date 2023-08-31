import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 1; i <= d + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (e > d || e - s <= l) {
                continue;
            }

            list.get(e).add(new Node(s, e, l));
        }

        int[] dist = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            dist[i] = dist[i - 1] + 1;
            for (Node node : list.get(i)) {
                dist[i] = Math.min(dist[i], dist[node.start] + node.cost);
            }
        }

        System.out.println(dist[d]);
    }

}