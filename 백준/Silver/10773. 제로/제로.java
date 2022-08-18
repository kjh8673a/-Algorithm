import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        // 합을 담을 변수
        int ans = 0;

        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now != 0) {
                // 0이 아니면 stack에 넣어주고, ans에 더해준다
                stack.push(now);
                ans += now;
            } else {
                // 0이면 stack에서 꺼내주고 ans에서 빼준다
                ans -= stack.pop();
            }
        }

        System.out.println(ans);

    }

}