import java.io.*;
import java.util.*;

public class Main {
    static int[] home;
    static ArrayList<int[]> milkList;
    static int h, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        home = new int[2];
        milkList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    home[0] = i;
                    home[1] = j;
                } else if (type == 2) {
                    milkList.add(new int[] { i, j });
                }
            }
        }

        answer = 0;
        visited = new boolean[milkList.size()];
        findRoute(home[0], home[1], 0, m);

        System.out.println(answer);
    }

    private static void findRoute(int r, int c, int cnt, int hp) {
        if (Math.abs(home[0] - r) + Math.abs(home[1] - c) <= hp) {
            answer = Math.max(answer, cnt);
        }

        for (int i = 0; i < milkList.size(); i++) {
            int[] milk = milkList.get(i);

            if (visited[i]) {
                continue;
            }

            int dist = Math.abs(milk[0] - r) + Math.abs(milk[1] - c);
            if (dist <= hp) {
                visited[i] = true;
                findRoute(milk[0], milk[1], cnt + 1, hp - dist + h);
                visited[i] = false;
            }
        }

    }

}