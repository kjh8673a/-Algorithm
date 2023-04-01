import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<Integer>());
        }
        int[] time = new int[N + 1]; // 해당 작업에 걸리는 시간 저장
        int[] in_degree = new int[N + 1]; // 선행되어야 할 작업의 개수 저장
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 해당 작업에 걸리는 시간
            int b = Integer.parseInt(st.nextToken()); // 선행 관계에 있는 작업의 개수
            for (int j = 0; j < b; j++) {
                list.get(Integer.parseInt(st.nextToken())).add(i);
            }
            time[i] = a;
            in_degree[i] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        int[] prev = new int[N + 1]; // 선행되어야 할 시간을 저장
        int ans = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            time[node] += prev[node];
            ans = Math.max(ans, time[node]);
            for (int next : list.get(node)) {
                in_degree[next]--;
                prev[next] = Math.max(prev[next], time[node]);
                if (in_degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(ans);

    }
}
