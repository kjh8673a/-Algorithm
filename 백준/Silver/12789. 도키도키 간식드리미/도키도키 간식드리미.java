import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int call = 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num != call) {
                while (!stack.isEmpty() && stack.peek() == call) {
                    stack.pop();
                    call++;
                }
                stack.push(num);
            } else {
                call++;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num != call) {
                System.out.println("Sad");
                return;
            } else {
                call++;
            }
        }

        System.out.println("Nice");
    }

}