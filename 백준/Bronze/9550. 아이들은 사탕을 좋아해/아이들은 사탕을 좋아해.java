import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cnt = Integer.parseInt(st.nextToken());
                sum += cnt / k;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}