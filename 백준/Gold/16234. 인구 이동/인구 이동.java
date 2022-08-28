import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visit;
    static HashSet<Integer> set;
    static int sum;
    static int dr[] = { 1, -1, 0, 0 };
    static int dc[] = { 0, 0, 1, -1 };
    static boolean isChanged = true;
    static int nowSize;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (isChanged) {
            isChanged = false;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        sum = 0;
                        set = new HashSet<>();
                        nowSize = map[i][j];
                        solve(i, j);
                        if(set.size() == 1) {
                            continue;
                        }
                        if (nowSize == -1) {
                            int area = sum / set.size();
                            change(area);
                            isChanged = true;
                        }
                    }
                }
            }
            if (isChanged) {
                ans++;
            }
        }

        System.out.println(ans);

    }

    public static void solve(int x, int y) {
        visit[x][y] = true;
        set.add(x * 100 + y);
        if (map[x][y] != nowSize) {
            nowSize = -1;
        }
        sum += map[x][y];

        for (int i = 0; i < 4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
                int chai = Math.abs(map[x][y] - map[nr][nc]);
                if (chai >= L && chai <= R) {
                    solve(nr, nc);
                }
            }
        }
    }

    public static void change(int area) {
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            int n = (int) iter.next();
            map[n / 100][n % 100] = area;
        }
    }

}