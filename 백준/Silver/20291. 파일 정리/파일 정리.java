import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine().split("\\.")[1];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().forEach(entry -> {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        });

        System.out.println(sb);

    }

}