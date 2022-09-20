import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int cnt;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

		// 파이프의 끝이 위치한 좌표를 (a,b)로 한다.
		// loc는 파이프가 놓여진 모양을 나타낸다.
		// 1 - 가로
		// 2 - 대각선
		// 3 - 세로
        solve(0, 1, 1);

        System.out.println(cnt);

    }

    public static void solve(int a, int b, int loc) {
		// 파이프의 끝점이 (n-1, n-1)에 위치했을때 종료한다
		// 이차원배열을 [n][n]으로 선언했기때문에 (n-1, n-1)이 종료지점.
        if(a == n-1 && b == n-1) {
            cnt++;
            return;
        }

        // 가로
        if(loc == 1 && b+1 < n && board[a][b+1] == 0) {
            solve(a, b+1, 1);
        }
        if(loc == 1 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }

		// 대각선
        if(loc == 2 && b+1 < n && board[a][b+1] == 0) {
            solve(a, b+1, 1);
        }
        if(loc == 2 && a+1 < n && board[a+1][b] == 0) {
            solve(a+1, b, 3);
        }
        if(loc == 2 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }

		// 세로
        if(loc == 3 && a+1 < n && board[a+1][b] == 0) {
            solve(a+1, b, 3);
        }
        if(loc == 3 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }
    }

}