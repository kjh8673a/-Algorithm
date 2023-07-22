import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] loop;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        loop = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (findLoop(i, i, i)) {
                break;
            }
        }

        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (loop[i]) {
                checkDist(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(dist[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void checkDist(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(start);
        visit[start] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                dist[now] = depth;

                for (int next : list.get(now)) {
                    if (!loop[next] && !visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }

            depth++;
        }

    }

    private static boolean findLoop(int prev, int now, int start) {
        loop[now] = true;
        for (int next : list.get(now)) {
            if (!loop[next]) {
                if (findLoop(now, next, start)) {
                    return true;
                }
            } else if (prev != next && start == next) {
                return true;
            }
        }
        loop[now] = false;
        return false;
    }

}
