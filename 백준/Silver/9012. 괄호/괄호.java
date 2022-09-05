import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++) {
                stack.add(str.charAt(j));
            }

            int cnt = 0;
            boolean isOk = true;
            while(!stack.isEmpty()) {
                char ch = stack.pop();

                if(ch == ')') cnt++;
                if(ch == '(') cnt--;

                if(cnt < 0) {
                    isOk = false;
                    break;
                }
            }
            if(cnt != 0) {
                isOk = false;
            }

            if(isOk) {
                sb.append("YES").append("\n");
            }else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());

    }

}
