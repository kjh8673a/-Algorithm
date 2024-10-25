import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c0 = Integer.parseInt(st.nextToken());
        int d0 = Integer.parseInt(st.nextToken());

        int[][] dumplings = new int[m + 1][4];
        dumplings[0][2] = c0;
        dumplings[0][3] = d0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            dumplings[i][0] = Integer.parseInt(st.nextToken()); // 남아있는 만두 속
            dumplings[i][1] = Integer.parseInt(st.nextToken()); // 하나를 만들기 위해서 필요한 만두 속
            dumplings[i][2] = Integer.parseInt(st.nextToken()); // 하나를 만들기 위해서 필요한 밀가루
            dumplings[i][3] = Integer.parseInt(st.nextToken()); // 만두 하나당 판매 금액
        }

        int[] dp = new int[n + 1]; // n그램의 밀가루로 만들었을 때 최대 금액
        for (int[] dumpling : dumplings) {
            for (int i = n; i >= dumpling[2]; i--) {
                int max = n / c0; // 남아있는 만두 속으로 만들 수 있는 개수
                if (dumpling[1] > 0) {
                    max = dumpling[0] / dumpling[1];
                }

                for (int j = 1; j <= max; j++) {
                    if (i - dumpling[2] * j < 0) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[i - dumpling[2] * j] + dumpling[3] * j);
                }
            }
        }

        System.out.println(dp[n]);
    }

}