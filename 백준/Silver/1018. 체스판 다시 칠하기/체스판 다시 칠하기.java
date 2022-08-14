import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] board;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                if(str.charAt(j) == 'W') {
                    board[i][j] = true;
                }else {
                    board[i][j] = false;
                }
                
            }
        }


        for(int i = 0; i <= n-8; i++) {
            for(int j = 0; j <= m-8; j++) {
                check(i, j);
            }
        }

        System.out.println(min);
    }

    public static void check(int x, int y) {
        int cnt = 0;

        boolean start = board[x][y];

        for(int i = x; i < x+8; i++) {
            for(int j = y; j < y+8; j++) {

                if(board[i][j] != start) {
                    cnt++;
                }

                start = !start;
            }

            start = !start;

        }

        cnt = Math.min(cnt, 64-cnt);

        min = Math.min(min, cnt);
    }

}