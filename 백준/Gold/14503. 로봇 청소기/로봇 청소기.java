import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] room;
    static int cnt;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

        clean1(r, c, d);

        System.out.println(cnt);

    }

    public static void clean1(int row, int col, int dir) {
        if (room[row][col] == 0) {
            room[row][col] = -1;
            cnt++;
        }
        clean2(row, col, dir);

    }

    public static void clean2(int row, int col, int dir) {
        int now = dir;
        boolean isClean = false;
        for (int i = 0; i < 4; i++) {
            int nd = (dir + 3) % 4;
            int nr = row + dr[nd];
            int nc = col + dc[nd];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && room[nr][nc] == 0) {
                clean1(nr, nc, nd);
                isClean = true;
                break;
            }

            dir = (dir + 3) % 4;
        }

        if (!isClean) {
            int nd = (now + 2) % 4;
            int nr = row + dr[nd];
            int nc = col + dc[nd];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && room[nr][nc] != 1) {
                clean1(nr, nc, now);
            }
        }
    }

}