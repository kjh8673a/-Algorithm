import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int answer = 0;

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int tmp = 1;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                tmp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                tmp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if (line.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if (line.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }

        if (!stack.isEmpty() || !flag) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }

}