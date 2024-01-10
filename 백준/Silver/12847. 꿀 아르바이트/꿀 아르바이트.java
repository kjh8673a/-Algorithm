import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sumOfDailyPay = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            sumOfDailyPay[i] += sumOfDailyPay[i - 1] + Long.parseLong(st.nextToken());
        }

        long maximumProfit = 0;
        for (int i = m; i < n + 1; i++) {
            long profit = sumOfDailyPay[i] - sumOfDailyPay[i - m];
            maximumProfit = Math.max(maximumProfit, profit);
        }

        System.out.println(maximumProfit);
    }

}