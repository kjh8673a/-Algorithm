import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] cnt = new int[1001];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                int[] map = new int[num + 1];
                for (int j = 2; j * j <= num; j++) {
                    while (num % j == 0) {
                        num /= j;
                        map[j]++;
                    }
                }
                if (num != 1) {
                    map[num]++;
                }

                for (int j = 1; j < map.length; j++) {
                    if (map[j] == 0) {
                        continue;
                    }
                    cnt[j] = Math.max(cnt[j], map[j]);
                }
            }

            long result = 1;
            for (int i = 1; i < 1001; i++) {
                if (cnt[i] == 0) {
                    continue;
                }
                result *= doPow(i, cnt[i]);
                result %= MOD;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static long doPow(int a, int b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                result *= a;
                result %= MOD;
            }
            a *= a;
            b >>= 1;
            a %= MOD;
        }
        return result;
    }

}