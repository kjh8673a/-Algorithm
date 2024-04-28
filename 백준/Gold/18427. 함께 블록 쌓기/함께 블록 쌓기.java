import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n + 1][h + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i - 1][0] = 1;
            for (int j = 1; j < h + 1; j++) {
                for (int height : list.get(i)) {
                    if (j >= height) {
                        dp[i][j] += dp[i - 1][j - height];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[n][h]);
    }

}