import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1~100까지 좌표를 담을 배열
        int[][] board = new int[101][101];

        // 좌표를 입력받아서 이중for문으로 board배열에 1적기
        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    board[j][k] = 1;
                }
            }

        }

        int sum = 0;

        // 배열 값이 1인 경우만 sum에 더해주기
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);

    }

}