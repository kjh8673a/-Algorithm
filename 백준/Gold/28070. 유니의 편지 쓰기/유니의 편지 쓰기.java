import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[120002];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int start_year = Integer.parseInt(a.split("-")[0]);
            int start_month = Integer.parseInt(a.split("-")[1]);
            dp[start_year * 12 + start_month]++;

            String b = st.nextToken();
            int end_year = Integer.parseInt(b.split("-")[0]);
            int end_month = Integer.parseInt(b.split("-")[1]);
            dp[end_year * 12 + end_month + 1]--;

        }

        for (int i = 24000; i < 120001; i++) {
            dp[i] += dp[i - 1];
        }

        int max = 0;
        int year = 0;
        int month = 0;
        for (int i = 24000; i < 120001; i++) {
            if (dp[i] > max) {
                max = dp[i];
                year = i / 12;
                month = i % 12;
            }
        }

        if (month == 0) {
            year--;
            month = 12;
        }

        if (month < 10) {
            System.out.println(year + "-0" + month);
        } else {
            System.out.println(year + "-" + month);
        }

    }

}