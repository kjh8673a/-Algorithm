import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in_degree = new int[N];
        List<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 가수의 수
            int a = Integer.parseInt(st.nextToken());

            // 첫번째 가수의 번호
            // 이전에 나와야될 가수를 from으로하고 다음에 나올가수를 to로한다
            // to의 in_degree를 증가시키고
            // 리스트에 추가한다
            int from = Integer.parseInt(st.nextToken()) - 1;
            for(int j = 1; j < a; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                in_degree[to]++;
                graph[from].add(to);
                from = to;
            }
        }

        // in_degree가 0인 것은 먼저 나와도 되는 것이다
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(in_degree[i] == 0) {
                queue.add(i);
            }
        }

        // in_degree가 0인것을 먼저 출력하고
        // 그것과 이어져있는것들의 in_degree를 1씩 감소시킨다
        // in_degree가 0이 되면 queue에 추가한다
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!queue.isEmpty()) {
            int num = queue.poll();

            sb.append(num + 1).append("\n");
            cnt++;

            for(int next : graph[num]) {
                in_degree[next]--;
                if(in_degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if(cnt == N) {
            System.out.println(sb.toString());
        }else {
            System.out.println(0);
        }
        
    }

}