import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }
        Arrays.sort(num);

        double mean = (double) sum / n;
        double median = 0;
        if (n % 2 == 0) {
            median = (double) (num[n / 2] + num[n / 2 - 1]) / 2;
        } else {
            median = num[n / 2];
        }

        System.out.println(String.format("%.6f", mean));
        System.out.println(String.format("%.6f", median));
    }
}