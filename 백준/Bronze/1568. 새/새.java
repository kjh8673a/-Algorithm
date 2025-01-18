import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int count = 1;

        while (n > 0) {
            if (count > n) {
                count = 1;
            }

            n -= count;
            answer++;
            count++;
        }

        System.out.println(answer);
    }

}