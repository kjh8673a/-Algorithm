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
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

        solve(0, 1, 1);

        System.out.println(cnt);

    }

    public static void solve(int a, int b, int loc) {
        if(a == n-1 && b == n-1) {
            cnt++;
            return;
        }
        
        if(loc == 1 && b+1 < n && board[a][b+1] == 0) {
            solve(a, b+1, 1);
        }
        if(loc == 1 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }

        if(loc == 2 && b+1 < n && board[a][b+1] == 0) {
            solve(a, b+1, 1);
        }
        if(loc == 2 && a+1 < n && board[a+1][b] == 0) {
            solve(a+1, b, 3);
        }
        if(loc == 2 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }

        if(loc == 3 && a+1 < n && board[a+1][b] == 0) {
            solve(a+1, b, 3);
        }
        if(loc == 3 && a+1 < n && b+1 < n && board[a+1][b+1] == 0 && board[a][b+1] == 0 && board[a+1][b] == 0) {
            solve(a+1, b+1, 2);
        }
    }

}