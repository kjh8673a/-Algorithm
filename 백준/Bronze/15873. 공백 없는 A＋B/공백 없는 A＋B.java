import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 100) {
            System.out.println(n / 10 + n % 10);
        } else if (n < 1000) {
            if (n % 10 == 0) {
                System.out.println(n / 100 + n % 100);
            } else {
                System.out.println(n / 10 + n % 10);
            }
        } else {
            System.out.println(n / 100 + n % 100);
        }
    }
}