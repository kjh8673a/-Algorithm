import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int mod = n % 100;

            sb.append((n + 1) % mod == 0 ? "Good" : "Bye").append("\n");
        }

        System.out.println(sb);
    }

}