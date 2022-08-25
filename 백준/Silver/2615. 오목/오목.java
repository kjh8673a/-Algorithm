import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] dr = {1, 1, 0, -1};
    static int[] dc = {1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = new int[20][20];

        for(int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 20; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int blackWins = 0;
        int whiteWins = 0;
        int a = 0;
        int b = 0;
        for(int i = 1; i < 20; i++) {
            for(int j = 1; j < 20; j++) {
                if(board[i][j] != 0) {
                    int num = checkWins(i, j, board[i][j]);
                    if(board[i][j] == 1) {
                        blackWins += num;
                    }else {
                        whiteWins += num;
                    }
                    if(num != 0) {
                        a = i;
                        b = j;
                    }
                }
            }
        }

        if(blackWins == 1 && whiteWins == 0) {
            sb.append("1").append("\n");
            sb.append(a + " " + b);
        }else if(blackWins == 0 && whiteWins == 1) {
            sb.append("2").append("\n");
            sb.append(a + " " + b);
        }else if(blackWins == 0 && whiteWins == 0) {
            sb.append("0");
        }

        System.out.println(sb.toString());
        
        
    }

    public static int checkWins(int a, int b, int color) {
        int win = 0;
        
        for(int i = 0; i < 4; i++) {
            if(a-dr[i] < 0 || b-dc[i] < 0 || a-dr[i] >= 20 || b-dc[i] >= 20 || board[a-dr[i]][b-dc[i]] == color) {
                continue;
            }

            int x = a + dr[i];
            int y = b + dc[i];

            if(x < 0 || y < 0 || x >= 20 || y >= 20) {
				continue;
			}

            int cnt = 1;
            while(board[x][y] == color) {
                cnt++;
                x += dr[i];
                y += dc[i];

                if(x < 0 || y < 0 || x >= 20 || y >= 20) {
					break;
				}

                if(cnt >= 6) break;
            }
            if(cnt == 5) {
                win++;
            }
            
        }

        return win;
    }

}
