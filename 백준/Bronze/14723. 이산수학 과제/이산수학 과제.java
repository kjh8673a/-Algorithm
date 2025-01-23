import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int stage = 1;
        while (sum < n) {
            sum += stage;
            stage++;
        }

        int a = 1;
        int b = stage - 1;
        while (sum > n) {
            sum--;
            a++;
            b--;
        }

        System.out.println(a + " " + b);
    }

}