import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (makeSum(i) == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static int makeSum(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

}