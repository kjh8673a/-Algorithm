import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        double[] numbers = new double[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch-0 >= 65 && ch-0 <= 90) { 
                stack.push(numbers[ch-65]);
            }else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = 0;

                switch(ch) {
                    case '+' :
                        result = num2 + num1;
                        break;
                    case '-' :
                        result = num2 - num1;
                        break;
                    case '*' :
                        result = num2 * num1;
                        break;
                    case '/' :
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

}