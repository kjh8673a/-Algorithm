import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[100][100];

        for(int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 좌표에 올려서 색종이 있는 칸 1로 칠해주기
            for(int i = y; i < y+10; i++) {
                for(int j = x; j < x+10; j++) {
                    board[i][j] = 1;
                }
            }
        }
        
        int ans = 0;
        // 가로방향
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(board[i][j] == 1) {
                    if((i-1 >= 0 && board[i-1][j] == 0) || i == 0) {
                        ans++;
                    }
                    if((i+1 < 100 && board[i+1][j] == 0) || i == 99) {
                        ans++;
                    }
                }
            }
        }

        // 세로방향
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(board[j][i] == 1) {
                    if((i-1 >= 0 && board[j][i-1] == 0) || i == 0) {
                        ans++;
                    }
                    if((i+1 < 100 && board[j][i+1] == 0) || i == 99) {
                        ans++;
                    }
                }
            }
        }

        // for(int i = 0; i < 100; i++) {
        //     for(int j = 0; j < 100; j++) {
        //         sb.append(board[i][j]);
        //         if(j == 99) {
        //             sb.append("\n");
        //         }
        //     }
        // }
        
        sb.append(ans);

        System.out.println(sb.toString());
        
    }

}


