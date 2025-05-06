import java.io.*;
import java.util.*;

public class Main {
    static int[] alphabet = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < a.length(); i++) {
            queue.add(alphabet[a.charAt(i) - 'A']);
            queue.add(alphabet[b.charAt(i) - 'A']);
        }

        while (queue.size() > 2) {
            int len = queue.size();
            int prev = queue.poll();
            for (int i = 1; i < len; i++) {
                int now = queue.poll();
                queue.add((prev + now) % 10);
                prev = now;
            }
        }

        System.out.println(queue.poll() + "" + queue.poll());
    }

}