import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> poll_a = new Stack<>();
        Stack<Integer> poll_b = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            poll_a.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int idx = n;
        while (idx > 0) {
            if (poll_a.contains(idx)) {
                while (poll_a.peek() != idx) {
                    poll_b.add(poll_a.pop());
                    sb.append(1 + " " + 2).append("\n");
                    count++;
                }
                poll_a.pop();
                sb.append(1 + " " + 3).append("\n");
                count++;
            } else {
                while (poll_b.peek() != idx) {
                    poll_a.add(poll_b.pop());
                    sb.append(2 + " " + 1).append("\n");
                    count++;
                }
                poll_b.pop();
                sb.append(2 + " " + 3).append("\n");
                count++;
            }
            idx--;
        }

        System.out.println(count);
        System.out.println(sb);
    }

}