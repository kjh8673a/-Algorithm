import java.io.*;
import java.util.*;

public class Main {
    static int N, S, P, ans;
    static ArrayList<ArrayList<Integer>> list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 얼음 블록의 개수
        S = Integer.parseInt(st.nextToken()); // 지지대 얼음의 개수
        P = Integer.parseInt(st.nextToken()); // 펭귄의 위치

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 펭귄과 지지대 블록의 거리 저장
        dist = new int[S + 1];

        bfs(P);

        int ans = N - 1;

        // 거리가 짧은 2개 지지대 블록까지의 얼음만 깨지 않는다.
        Arrays.sort(dist);
        ans -= dist[1];
        ans -= dist[2];

        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(start);
        visit[start] = true;

        int depth = -1;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int num = queue.poll();
                if (num <= S) {
                    dist[num] = depth;
                    continue;
                }

                for (int next : list.get(num)) {
                    if (!visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }

        }
    }

}
