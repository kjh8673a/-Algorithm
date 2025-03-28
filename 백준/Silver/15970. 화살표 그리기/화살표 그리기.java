import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }

        int sum = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();

            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                int node = list.get(i);

                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if (i != 0) {
                    a = node - list.get(i - 1);
                }
                if (i != list.size() - 1) {
                    b = list.get(i + 1) - node;
                }

                sum += Math.min(a, b);
            }
        }

        System.out.println(sum);
    }

}