import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        long n = 0;
        while ((n = Long.parseLong(br.readLine())) != 0) {
            sb.append(n * (n + 1) / 2).append("\n");
        }

        System.out.println(sb);
    }

}