import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[1000 * k + 2];
        int num = 1;
        while (true) {
            if (set.contains(num)) {
                dp[num] = 1;
            } else {
                dp[num] = Integer.MAX_VALUE;
                for (int i = 1; i <= num / 2; i++) {
                    if (dp[num - i] + dp[i] > k) {
                        continue;
                    }
                    dp[num] = Math.min(dp[num - i] + dp[i], dp[num]);
                }
            }

            if (dp[num] == Integer.MAX_VALUE) {
                break;
            }

            num++;
        }

        if (num % 2 == 0) {
            System.out.println("holsoon win at " + num);
        } else {
            System.out.println("jjaksoon win at " + num);
        }
    }

}