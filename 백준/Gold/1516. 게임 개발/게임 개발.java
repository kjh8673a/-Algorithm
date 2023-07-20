import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        int[] time = new int[N + 1];
        int[] in_degree = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int from = Integer.parseInt(st.nextToken());
                if (from == -1) {
                    break;
                }
                list.get(from).add(i);
                in_degree[i]++;
            }
        }

        int[] answer = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
                answer[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : list.get(node)) {
                answer[next] = Math.max(answer[next], answer[node] + time[next]);

                if (--in_degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

}
