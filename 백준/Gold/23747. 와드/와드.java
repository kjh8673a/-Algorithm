import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] board;
    static boolean[][] result;
    static String moves;

    static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int Hr = Integer.parseInt(st.nextToken()) - 1;
        int Hc = Integer.parseInt(st.nextToken()) - 1;
        moves = br.readLine();

        result = new boolean[r][c];
        moving(Hr, Hc, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(result[i][j] ? '.' : '#');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void moving(int hr, int hc, int idx) {
        if (idx == moves.length()) {
            for (int k = 0; k < 4; k++) {
                int nr = hr + vector[k][0];
                int nc = hc + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                    continue;
                }

                result[nr][nc] = true;
            }
            result[hr][hc] = true;
            return;
        }

        char move = moves.charAt(idx);
        switch (move) {
            case 'W':
                putWard(hr, hc);
                moving(hr, hc, idx + 1);
                break;

            case 'U':
                moving(hr - 1, hc, idx + 1);
                break;

            case 'D':
                moving(hr + 1, hc, idx + 1);
                break;

            case 'L':
                moving(hr, hc - 1, idx + 1);
                break;

            case 'R':
                moving(hr, hc + 1, idx + 1);
                break;
        }
    }

    private static void putWard(int hr, int hc) {
        char type = board[hr][hc];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { hr, hc });

        result[hr][hc] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                    continue;
                }

                if (result[nr][nc] || board[nr][nc] != type) {
                    continue;
                }

                result[nr][nc] = true;
                queue.add(new int[] { nr, nc });
            }
        }
    }

}