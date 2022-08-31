import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board, student;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        int len = n * n;

        student = new int[len+1][4];
        for(int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            findSeat(num, a, b, c, d);
            
            student[num][0] = a;
            student[num][1] = b;
            student[num][2] = c;
            student[num][3] = d;
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(score());

    }

    public static void findSeat(int num, int a, int b, int c, int d) {
        int[][] nearLike = new int[n][n];
        int[][] nearEmpty = new int[n][n];

        int maxLike = 0;
        int maxEmpty = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != 0) {
                    continue;
                }

                for(int k = 0; k < 4; k++) {
                    int x = i + dr[k];
                    int y = j + dc[k];

                    if(x >= 0 && y >= 0 && x < n && y < n) {
                        if(board[x][y] == a || board[x][y] == b || board[x][y] == c || board[x][y] == d) {
                            nearLike[i][j]++;
                        }

                        if(board[x][y] == 0) {
                            nearEmpty[i][j]++;
                        }
                    }
                }
                if(maxLike < nearLike[i][j]) {
                    maxLike = Math.max(nearLike[i][j], maxLike);
                    maxEmpty = nearEmpty[i][j];
                }else if(maxLike == nearLike[i][j]) {
                    maxEmpty = Math.max(nearEmpty[i][j], maxEmpty);
                }
                
            }
        }

        loop: 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0 && nearLike[i][j] == maxLike && nearEmpty[i][j] == maxEmpty) {
                    board[i][j] = num;
                    break loop;
                }
            }
        }

    }


    public static int score() {
        int score = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                int cnt = 0;
                int now = board[i][j];
                for(int k = 0; k < 4; k++) {
                    int x = i + dr[k];
                    int y = j + dc[k];

                    if(x >= 0 && y >= 0 && x < n && y < n) {
                        if(board[x][y] == student[now][0] || board[x][y] == student[now][1] || board[x][y] == student[now][2] || board[x][y] == student[now][3]) {
                            cnt++;
                        }
                    }
                }

                switch(cnt) {
                    case 0 :
                        score += 0;
                        break;
                    case 1 :
                        score += 1;
                        break;
                    case 2 :
                        score += 10;
                        break;
                    case 3 :
                        score += 100;
                        break;
                    case 4 :
                        score += 1000;
                }
            }
        }

        return score;
    }

}