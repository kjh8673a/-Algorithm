import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }

            Map<Integer, Integer> map_a = calculate(a);
            Map<Integer, Integer> map_b = calculate(b);

            int x = map_a.size();
            int d = 0;
            for (Map.Entry<Integer, Integer> entry : map_b.entrySet()) {
                if (!map_a.containsKey(entry.getKey())) {
                    x++;
                    d += entry.getValue();
                } else if (map_a.get(entry.getKey()) < entry.getValue()) {
                    d += entry.getValue() - map_a.get(entry.getKey());
                }
            }

            for (Map.Entry<Integer, Integer> entry : map_a.entrySet()) {
                if (!map_b.containsKey(entry.getKey())) {
                    d += entry.getValue();
                } else if (map_b.get(entry.getKey()) < entry.getValue()) {
                    d += entry.getValue() - map_b.get(entry.getKey());
                }
            }

            if (x == 0) {
                x++;
            }

            sb.append(idx + ". " + x + ":" + d).append("\n");
            idx++;
        }

        System.out.println(sb);
    }

    private static Map<Integer, Integer> calculate(int x) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                x /= i;
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        if (x != 1) {
            map.put(x, 1);
        }

        return map;
    }
}