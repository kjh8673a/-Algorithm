import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            Map<String, Integer> publicKey = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                publicKey.put(st.nextToken(), i);
            }

            int[] decode = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                decode[i] = publicKey.get(st.nextToken()) - i;
            }

            String[] answer = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int position = i + decode[i];
                answer[position] = st.nextToken();
            }

            for (int i = 0; i < n; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}