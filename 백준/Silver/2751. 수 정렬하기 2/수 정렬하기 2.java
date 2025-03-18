import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] count = new int[2_000_001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num + 1_000_000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2_000_001; i++) {
            while (count[i] > 0) {
                sb.append(i - 1_000_000).append("\n");
                count[i]--;
            }
        }

        System.out.println(sb.toString());
    }

}