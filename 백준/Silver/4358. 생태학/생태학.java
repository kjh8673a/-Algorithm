import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> map = new TreeMap<>();
        String input;
        int cnt = 0;
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double num = (double) entry.getValue() / cnt * 100;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", num)).append("\n");
        }

        System.out.println(sb);
    }

}
