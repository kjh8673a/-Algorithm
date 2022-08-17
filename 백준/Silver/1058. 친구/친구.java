import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                if(str.charAt(j) == 'Y') board[i][j] = 1;
                else board[i][j] = 0;
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    cnt++;
                    for(int k = 0; k < N; k++) {
                        if(board[j][k] == 1 && board[i][k] == 0 && i != k) {
                            board[i][k] = 2;
                            cnt++;
                        }
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }

}