import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == ')' && c == '('))) {
                stack.pop();
            } else {
                stack.push(c);
            }

            answer = Math.max(answer, stack.size());
        }

        if (!stack.isEmpty()) {
            answer = -1;
        }

        System.out.println(answer);
    }

}