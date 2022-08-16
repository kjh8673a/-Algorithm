import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Map<String, Integer> order = new HashMap<String, Integer>() {
            {
                put("*", 2);
                put("/", 2);
                put("+", 1);
                put("-", 1);
                put("(", 0);
            }
        };

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch - 0 >= 65 && ch - 0 <= 90)) {
                sb.append(ch);
            } else if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                switch (ch) {
                    case '(':
                        stack.push(ch);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty()
                                && order.get(String.valueOf(stack.peek())) >= order.get(String.valueOf(ch))) {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

}