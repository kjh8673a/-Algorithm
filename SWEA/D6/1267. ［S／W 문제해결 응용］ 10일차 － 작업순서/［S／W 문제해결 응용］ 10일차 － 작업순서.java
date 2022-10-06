import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[] in_degree = new int[v + 1];
            int[][] adj = new int[v + 1][v + 1];

            int cnt = 0;
            int from = 0;
            int to = 0;
            st = new StringTokenizer(br.readLine());
            while(cnt != 2 * e) {                
                int now = Integer.parseInt(st.nextToken());
                cnt++;

                if(from == 0) {
                    from = now;
                }else {
                    to = now;
                    adj[from][to] = 1;
                    in_degree[to]++;
                    from = to = 0;
                }

            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < v + 1; i++) {
                if (in_degree[i] == 0) {
                    queue.add(i);
                }
            }

            sb.append("#" + tc + " ");

            while (!queue.isEmpty()) {
                int node = queue.poll();
                sb.append(node + " ");

                for (int i = 1; i < v+1; i++) {
                    if (adj[node][i] == 1) {
                        in_degree[i]--;

                        if (in_degree[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }

            sb.append("\n");

        }

        System.out.println(sb.toString());

    }
}