import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) {
                break;
            }

            int target = 0;
            int[] nodes = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
                if (nodes[i] == k) {
                    target = i;
                }
            }

            int idx = -1;
            int[] parent = new int[n];
            for (int i = 1; i < n; i++) {
                if (nodes[i] - 1 != nodes[i - 1]) {
                    idx++;
                }
                parent[i] = idx;
            }

            int answer = 0;
            for (int i = 0; i < n && parent[target] != 0; i++) {
                if (parent[i] == parent[parent[i]]) {
                    continue;
                }
                if (parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}