import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                ans++;
            }

            if (y != 0 && (stack.isEmpty() || stack.peek() != y)) {
                stack.push(y);
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            ans++;
        }

        System.out.println(ans);
    }

}
