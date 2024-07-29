import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());

        Map<Long, Integer> visited = new HashMap<>();
        Queue<Long> queue = new LinkedList<>();
        visited.put(x, 0);
        queue.add(x);

        while (!queue.isEmpty()) {
            long node = queue.poll();
            int depth = visited.get(node);

            if (node == 1) {
                System.out.println(depth);
                return;
            }

            if (node % 3 == 0 && !visited.containsKey(node / 3)) {
                visited.put(node / 3, depth + 1);
                queue.add(node / 3);
            }

            if (node % 2 == 0 && !visited.containsKey(node / 2)) {
                visited.put(node / 2, depth + 1);
                queue.add(node / 2);
            }

            if (node - 1 > 0 && !visited.containsKey(node - 1)) {
                visited.put(node - 1, depth + 1);
                queue.add(node - 1);
            }
        }
    }

}