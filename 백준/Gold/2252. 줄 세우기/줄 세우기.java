import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in_degree = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            in_degree[B]++;
            graph[A].add(B);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int from = queue.poll();

            sb.append(from + 1).append("\n");

            for (int to : graph[from]) {
                in_degree[to]--;
                if (in_degree[to] == 0) {
                    queue.add(to);
                }
            }
        }

        System.out.println(sb.toString());

    }

}