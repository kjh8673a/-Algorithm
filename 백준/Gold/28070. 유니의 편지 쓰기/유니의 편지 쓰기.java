import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[10000][13];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int start_year = Integer.parseInt(a.split("-")[0]);
            int start_month = Integer.parseInt(a.split("-")[1]);
            dp[start_year][start_month]++;

            String b = st.nextToken();
            int end_year = Integer.parseInt(b.split("-")[0]);
            int end_month = Integer.parseInt(b.split("-")[1]);
            if (end_year == 9999 && end_month == 12) {
                continue;
            }
            if (end_month == 12) {
                dp[end_year + 1][1]--;
            } else {
                dp[end_year][end_month + 1]--;
            }

        }

        for (int i = 2000; i < 10000; i++) {
            for (int j = 1; j < 13; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][12];
                } else {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        int max = 0;
        int year = 0;
        int month = 0;
        for (int i = 2000; i < 10000; i++) {
            for (int j = 1; j < 13; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    year = i;
                    month = j;
                }
            }
        }

        if (month < 10) {
            System.out.println(year + "-0" + month);
        } else {
            System.out.println(year + "-" + month);
        }

    }

}