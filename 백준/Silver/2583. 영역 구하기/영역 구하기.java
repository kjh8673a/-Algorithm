import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int M, N, K;
    static int[][] board;
    static boolean[][] visit;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        visit = new boolean[M][N];

        map = new HashMap<>();

        int cnt = 0;
        int idx = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0 && !visit[i][j]) {
                    dfs(i, j, idx);
                    idx++;
                    cnt++;
                }
            }
        }

        sb.append(cnt).append("\n");

        int[] size = new int[map.size()];
        int index = 0;
        for(int key : map.keySet()) {
            size[index++] = map.get(key);
        }

        Arrays.sort(size);

        for(int i = 0; i < size.length; i++) {
            sb.append(size[i] + " ");
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int x, int y, int key) {
        visit[x][y] = true;

        map.put(key, map.getOrDefault(key, 0) + 1);

        for(int i = 0; i < 4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];

            if(nr >= 0 && nc >= 0 && nr < M && nc < N) {
                if(board[nr][nc] == 0 && !visit[nr][nc]) {
                    dfs(nr, nc, key);
                }
            }
        }
    }

}