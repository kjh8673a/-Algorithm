import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.size() == m) {
                break;
            }

            char ch = str.charAt(i);
            if (stack.isEmpty()) {
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    continue;
                }
            } else if (stack.size() < 3) {
                if (ch != 'A') {
                    continue;
                }
            }
            stack.add(ch);
        }

        if (stack.size() != m) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }

}