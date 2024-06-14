import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("Case #" + tc + ": ");
            if (map.containsKey(n)) {
                sb.append(map.get(n));
            } else {
                int count = eatCake(n);
                sb.append(count);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int eatCake(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int x = (int) Math.sqrt(n);
        int result = Integer.MAX_VALUE;
        while (x > 0) {
            int count = n / (x * x);
            int remain = n % (x * x);
            if (remain > 0) {
                count += eatCake(remain);
            }
            result = Math.min(result, count);
            x--;
        }

        map.put(n, result);
        return result;
    }

}