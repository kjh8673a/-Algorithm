import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] gn = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int depth = 1;
            while (i * depth <= n) {
                gn[i * depth] += i;
                depth++;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            gn[i] += gn[i - 1];
        }

        System.out.println(gn[n]);
    }

}