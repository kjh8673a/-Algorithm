import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            } else if (a == 2) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            } else {
                sb.append(n - set.size()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}