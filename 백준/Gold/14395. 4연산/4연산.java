import java.io.*;
import java.util.*;

public class Main {
    static final long LIMIT = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if (s == t) {
            System.out.println(0);
        } else if (t == 1) {
            System.out.println("/");
        } else {
            System.out.println(bfs(s, t));
        }
    }

    private static String bfs(int s, int t) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(s, ""));

        HashSet<Long> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Number node = queue.poll();
            if (node.num == t) {
                return node.history;
            }

            long now = node.num;

            if (now * now <= LIMIT && !visited.contains(now * now)) {
                visited.add(now * now);
                queue.add(new Number(now * now, node.history + "*"));
            }

            if (now + now <= LIMIT && !visited.contains(now + now)) {
                visited.add(now + now);
                queue.add(new Number(now + now, node.history + "+"));
            }

            if (now - now <= LIMIT && !visited.contains(now - now)) {
                visited.add(now - now);
                queue.add(new Number(now - now, node.history + "-"));
            }

            if (now > 0 && now / now <= LIMIT && !visited.contains(now / now)) {
                visited.add(now / now);
                queue.add(new Number(now / now, node.history + "/"));
            }
        }

        return "-1";
    }

    static class Number {
        long num;
        String history;

        public Number(long num, String history) {
            this.num = num;
            this.history = history;
        }
    }

}