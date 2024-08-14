import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        answer += (n / 18) * 2;
        int mod = n % 18;
        if (mod > 0 && mod < 10) {
            answer++;
        } else if (mod >= 10) {
            if (mod % 2 == 0) {
                answer += 2;
            } else {
                answer += 3;
            }
        }

        System.out.println(answer);
    }
}