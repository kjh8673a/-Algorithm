import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int level;
        TreeMap<String, Integer> map;

        public Node(int level) {
            this.level = level;
            map = new TreeMap<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean flag = false;
            for (Node node : list) {
                if (node.map.size() == m) {
                    continue;
                }
                if (Math.abs(node.level - level) <= 10) {
                    node.map.put(name, level);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                Node node = new Node(level);
                node.map.put(name, level);
                list.add(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            if (node.map.size() < m) {
                sb.append("Waiting!").append("\n");
            } else {
                sb.append("Started!").append("\n");
            }

            for (Map.Entry<String, Integer> entry : node.map.entrySet()) {
                String name = entry.getKey();
                int level = entry.getValue();
                sb.append(level + " " + name).append("\n");
            }
        }

        System.out.println(sb);
    }

}
