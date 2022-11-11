import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0인곳을 저장하려면? 저장을 해야하나?
        // List로 저장하면 get으로 가져와야하는데 느리다
        // 저장 없이 해보자
        board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        doSudoku(0);
    }

    public static void doSudoku(int idx) {
        if(idx == 81) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        int r = idx / 9;
        int c = idx % 9;

        if(board[r][c] != 0) {
            doSudoku(idx + 1);
        }else {
            boolean[] check = new boolean[10];

            // 가로
            for(int i = 0; i < 9; i++) {
                check[board[r][i]] = true;
            }

            // 세로
            for(int i = 0; i < 9; i++) {
                check[board[i][c]] = true;
            }

            // 3*3
            int nr = r / 3 * 3;
            int nc = c / 3 * 3;
            for(int i = nr; i < nr + 3; i++) {
                for(int j = nc; j < nc + 3; j++) {
                    check[board[i][j]] = true;
                }
            }

            for(int i = 1; i < 10; i++) {
                if(!check[i]) {
                    board[r][c] = i;
                    doSudoku(idx + 1);
                    board[r][c] = 0;
                }
            }

        }
    }
}