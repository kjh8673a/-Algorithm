import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }

            if (stack.size() == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}