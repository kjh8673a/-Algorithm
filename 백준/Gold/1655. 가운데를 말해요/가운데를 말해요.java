import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.add(num);
            } else if (left.peek() >= num) {
                left.add(num);
            } else {
                right.add(num);
            }

            while (left.size() - right.size() > 1) {
                right.add(left.poll());
            }

            while (right.size() - left.size() > 0) {
                left.add(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }

}
