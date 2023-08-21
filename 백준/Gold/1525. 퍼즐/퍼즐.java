import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String org = "";
        for (int i = 0; i < 3; i++) {
            String tmp = br.readLine().replace(" ", "");
            org += tmp;
        }

        System.out.println(bfs(org));
    }

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private static int bfs(String original) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        queue.add(original);
        map.put(original, 0);

        while (!queue.isEmpty()) {
            String s = queue.poll();

            if (s.equals("123456780")) {
                return map.get(s);
            }

            int idx = s.indexOf('0');
            int r = idx / 3;
            int c = idx % 3;

            for (int i = 0; i < 4; i++) {
                int nr = r + vector[i][0];
                int nc = c + vector[i][1];

                if (nr < 0 || nc < 0 || nr > 2 || nc > 2) {
                    continue;
                }

                int nidx = nr * 3 + nc;
                char tmp = s.charAt(nidx);
                String next = s.replace(tmp, 'x');
                next = next.replace('0', tmp);
                next = next.replace('x', '0');

                if (!map.containsKey(next)) {
                    queue.add(next);
                    map.put(next, map.get(s) + 1);
                }
            }
        }

        return -1;
    }

}