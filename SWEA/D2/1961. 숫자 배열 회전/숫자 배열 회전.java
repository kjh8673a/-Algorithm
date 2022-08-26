import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] board;
    static String[][] result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
 
            board = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            result = new String[N][3];
 
            degree90();
            degree180();
            degree270();
 
            sb.append("#" + tc).append("\n");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < 3; j++) {
                    sb.append(result[i][j] + " ");
                    if(j == 2) sb.append("\n");
                }
            }
        }
 
        System.out.println(sb.toString());
 
    }
 
    public static void degree90() {
        for(int i = 0; i < N; i++) {
            String num = "";
            for(int j = N-1; j >= 0; j--) {
                num += String.valueOf(board[j][i]);
            }
            result[i][0] = num;
        }
    }
 
    public static void degree180() {
        int idx = 0;
        for(int i = N-1; i >= 0; i--) {
            String num = "";
            for(int j = N-1; j >= 0; j--) {
                num += String.valueOf(board[i][j]);
            }
            result[idx++][1] = num;
        }
    }
 
    public static void degree270() {
        int idx = 0;
        for(int i = N-1; i >= 0; i--) {
            String num = "";
            for(int j = 0; j < N; j++) {
                num += String.valueOf(board[j][i]);
            }
            result[idx++][2] = num;
        }
         
    }
 
}