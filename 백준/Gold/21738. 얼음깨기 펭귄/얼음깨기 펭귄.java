import java.io.*;
import java.util.*;

public class Main {
    static int N, S, P, ans;
    static ArrayList<ArrayList<Integer>> list;

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

        ans = N - 1;

        bfs(P);

        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(start);
        visit[start] = true;

        int depth = -1;
        int closeCnt = 0;
        while (!queue.isEmpty() && closeCnt < 2) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int num = queue.poll();
                if (num <= S && closeCnt < 2) {
                    ans -= depth;
                    closeCnt++;
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
