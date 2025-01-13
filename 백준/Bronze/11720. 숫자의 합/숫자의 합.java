import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        String numbers = br.readLine();
        for (int i = 0; i < n; i++) {
            sum += numbers.charAt(i) - '0';
        }

        System.out.println(sum);
    }

}