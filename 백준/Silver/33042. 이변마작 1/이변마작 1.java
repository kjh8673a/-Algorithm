import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            String s = st.nextToken();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) == 5) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

}