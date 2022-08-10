import java.util.Scanner;

public class Main {
    static int[] dr = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dc = {1, -1, 0 , 0, -1, 1, 1, -1};
    static int w;
    static int h;
    static int[][] map;
    static int cnt;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if(w == 0 && h == 0) {
                sc.close();
                break;
            }

            map = new int[h][w];

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            visit = new boolean[h][w];

            cnt = 0;

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }

    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for(int i = 0; i < 8; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];

            if(nr >= 0 && nc >= 0 && nr < h && nc < w) {
                if(map[nr][nc] == 1 && !visit[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}