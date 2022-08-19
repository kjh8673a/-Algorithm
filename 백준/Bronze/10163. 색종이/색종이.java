import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            minX = Math.min(a, minX);
            minY = Math.min(b, minY);
            maxX = Math.max(a+c, maxX);
            maxY = Math.max(b+d, maxY);

            arr[i][0] = a;            
            arr[i][1] = b;
            arr[i][2] = a + c;
            arr[i][3] = b + d;
        }

        int[][] board = new int[maxX-minX][maxY-minY];

        int idx = 0;
        while(idx != n) {
            for(int i = arr[idx][0]-minX; i < arr[idx][2]-minX; i++) {
                for(int j = arr[idx][1]-minY; j < arr[idx][3]-minY; j++) {
                    board[i][j] = idx+1;
                }
            }
            idx++;
        }

        int[] cnt = new int[n+1];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                cnt[board[i][j]]++;
            }
        }
        
        for(int i = 1; i < n+1; i++) {
            sb.append(cnt[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

}