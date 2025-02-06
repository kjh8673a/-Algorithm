import java.io.*;

public class Main {
    static int sum, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sum = 0;
        idx = 2;
        for (int i = 2; i <= n; i++) {
            checkSum(n, i);
        }

        System.out.println(sum + " " + idx);
    }

    private static void checkSum(int n, int i) {
        int result = 0;
        if (n == 0) {
            return;
        }

        while (n > 0) {
            int tmp = n % i;

            result += tmp;
            n /= i;
        }

        if (result > sum) {
            sum = result;
            idx = i;
        }
    }

}