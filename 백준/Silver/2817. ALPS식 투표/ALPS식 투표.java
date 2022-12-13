import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static class Node {
        String name;
        double score;

        public Node(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        Map<String, Integer> result = new TreeMap<>(comparator);

        StringTokenizer st;
        Node[] list = new Node[14 * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());
            if ((long) vote * 20 >= x) {
                result.put(name, 0);
                for (int j = 1; j <= 14; j++) {
                    double score = vote / j;
                    list[idx] = new Node(name, score);
                    idx++;
                }
            } else {
                for (int j = 1; j <= 14; j++) {
                    double score = 0;
                    list[idx] = new Node(name, score);
                    idx++;
                }
            }
        }

        Arrays.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o2.score, o1.score);
            }
        });

        for (int i = 0; i < 14; i++) {
            Node curr = list[i];
            result.put(curr.name, result.getOrDefault(curr.name, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : result.keySet()) {
            sb.append(key + " " + result.get(key)).append("\n");
        }

        System.out.println(sb.toString());

    }

}