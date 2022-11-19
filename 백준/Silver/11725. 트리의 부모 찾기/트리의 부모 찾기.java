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

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int[] parent = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int next : list[num]) {
                if(!visit[next]) {
                    visit[next] = true;
                    parent[next] = num;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

}