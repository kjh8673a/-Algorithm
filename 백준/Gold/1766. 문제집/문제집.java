import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in_degree = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            in_degree[to]++;
            graph[from].add(to);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (in_degree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int point = pq.poll();
            sb.append(point + 1 + " ");

            for(int next : graph[point]) {
                in_degree[next]--;
                if(in_degree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}