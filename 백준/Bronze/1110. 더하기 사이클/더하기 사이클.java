import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = n;

        int cycle = 0;
        while (true) {
            cycle++;
            int a = n / 10;
            int b = n % 10;
            n = b * 10 + (a + b) % 10;

            if (start == n) {
                break;
            }
        }

        System.out.println(cycle);
    }
}