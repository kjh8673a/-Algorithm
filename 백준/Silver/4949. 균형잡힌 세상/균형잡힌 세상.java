import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();

            if(str.equals(".")) {
                break;
            }

            Stack<Integer> stack = new Stack<>();

            boolean balance = true;

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') {
                    stack.add(1);
                }
                if(str.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.peek() != 1) {
                        balance = false;
                        break;
                    }
                    stack.pop();
                }
                if(str.charAt(i) == '[') {
                    stack.add(2);
                }
                if(str.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.peek() != 2) {
                        balance = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(stack.size() != 0) {
                balance = false;
            }

            if(balance) {
                sb.append("yes").append("\n");
            }else {
                sb.append("no").append("\n");
            }

        }

        System.out.println(sb.toString());

    }

}