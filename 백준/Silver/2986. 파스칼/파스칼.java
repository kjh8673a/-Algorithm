import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = n - 1; i > 0; i--) {
            answer++;
            if (n % i == 0) {
                break;
            }
        }

        System.out.println(answer);
    }

}