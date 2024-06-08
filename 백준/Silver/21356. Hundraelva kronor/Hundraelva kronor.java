import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (n > 0) {
            int money = 0;
            int idx = 1;
            while (money * 10 < n) {
                money += idx;
                idx *= 10;
            }
            answer += n / money;
            n %= money;
        }

        System.out.println(answer);
    }

}