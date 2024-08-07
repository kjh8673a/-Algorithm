import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = 0;
        long tmp = 0;
        while (tmp < n) {
            if (tmp == 0) {
                tmp++;
            } else {
                tmp *= 2;
            }
            answer++;
        }

        System.out.println(answer);
    }

}