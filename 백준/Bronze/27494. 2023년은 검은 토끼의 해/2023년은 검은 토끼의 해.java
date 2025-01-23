import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] win = { 2, 0, 2, 3 };
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int idx = 3;
            while (num > 0 && idx >= 0) {
                if (num % 10 == win[idx]) {
                    idx--;
                }
                num /= 10;
            }

            if (idx == -1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}