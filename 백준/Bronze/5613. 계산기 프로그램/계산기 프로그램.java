import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());

        while (true) {
            char type = br.readLine().charAt(0);
            if (type == '=') {
                break;
            }

            int num = Integer.parseInt(br.readLine());
            switch (type) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                case '/':
                    result /= num;
                    break;
            }
        }

        System.out.println(result);
    }

}