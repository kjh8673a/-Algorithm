import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            map.put(s, map.getOrDefault(s, 0) + x);
        }

        boolean flag = false;
        Object[] arr = map.keySet().toArray();
        loop: for (int i = 0; i < arr.length - 1; i++) {
            int originalA = map.get(arr[i]);
            int goldenA = (int) Math.floor(originalA * 1.618);
            for (int j = i + 1; j < arr.length; j++) {
                int originalB = map.get(arr[j]);
                int goldenB = (int) Math.floor(originalB * 1.618);
                if (originalA == goldenB || goldenA == originalB) {
                    flag = true;
                    break loop;
                }
            }
        }

        System.out.println(flag ? "Delicious!" : "Not Delicious...");
    }

}