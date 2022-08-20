import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int cnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        board = new int[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        int idx = 0;
        cnt = 0;

        bingo : 
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                idx++;
                int num = Integer.parseInt(st.nextToken());

                search : 
                for(int k = 0; k < 5; k++) {
                    for(int l = 0; l < 5; l++) {
                        if(board[k][l] == num) {
                            board[k][l] = 0;
                            break search;
                        }
                    }
                }

                check_toLeft();
                check_toDown();
                check_toLeftX();
                check_toRightX();

                if(cnt >= 3) {
                    System.out.println(idx);
                    break bingo;
                }

                cnt = 0;

            }
        }

    }

    public static void check_toLeft() {
        for(int i = 0; i < 5; i++) {
            boolean line = true;
            for(int j = 0; j < 5; j++) {
                if(board[i][j] != 0) {
                    line = false;
                    break;
                }
            }
            if(line) cnt++;
        }
    }

    public static void check_toDown() {
        for(int i = 0; i < 5; i++) {
            boolean line = true;
            for(int j = 0; j < 5; j++) {
                if(board[j][i] != 0) {
                    line = false;
                    break;
                }
            }
            if(line) cnt++;
        }
    }

    public static void check_toLeftX() {
        boolean line = true;
        for(int i = 0; i < 5; i++) {
            if(board[i][i] != 0) {
                line = false;
                break;
            }
        }
        if(line) cnt++;
    }

    public static void check_toRightX() {
        boolean line = true;
        for(int i = 0; i < 5; i++) {
            if(board[i][4-i] != 0) {
                line = false;
                break;
            }
        }
        if(line) cnt++;
    }

}
