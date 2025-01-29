import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int sum = 0;
        int mode = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                mode = entry.getKey();
                count = entry.getValue();
            }

            sum += entry.getKey() * entry.getValue();
        }

        System.out.println(sum / 10);
        System.out.println(mode);
    }

}