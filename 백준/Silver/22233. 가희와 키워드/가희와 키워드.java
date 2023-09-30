import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> keyword = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keyword.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(",");
            for (String word : arr) {
                if (keyword.contains(word)) {
                    keyword.remove(word);
                }
            }

            sb.append(keyword.size()).append("\n");
        }

        System.out.println(sb);
    }

}
