import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        

        int idx = 0;
        boolean possible = true;
        for(int tc = 0; tc < N; tc++) {
            int num = Integer.parseInt(br.readLine());

            if(num > idx) {
                for(int i = idx+1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                idx = num;
            }else if(stack.peek() != num) {
                possible = false;
            }

            if(num == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            }
        
        }
            
        if(!possible) {
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
        
    }

}