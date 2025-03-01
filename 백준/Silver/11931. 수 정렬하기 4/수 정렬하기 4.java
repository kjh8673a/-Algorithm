import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] count = new int[2_000_001];
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2_000_000; i >= 0; i--) {
            if (count[i] > 0) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}