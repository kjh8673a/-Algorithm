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

            if (left.isEmpty() || left.peek() >= num) {
                left.add(num);
            } else {
                right.add(num);
            }

            int diff = left.size() - right.size();
            if (diff == 2) {
                right.add(left.poll());
            } else if (diff == -1) {
                left.add(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }

}
