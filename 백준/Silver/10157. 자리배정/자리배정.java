import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int k = Integer.parseInt(br.readLine());

        if(k > c * r) {
            System.out.println(0);
            System.exit(0);
        }

        int now = 1;

        int x = r-1;
        int y = 0;
        int dir = 0;

        while(now != k) {

            map[x][y] = now;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] != 0) {
                dir++;
                dir %= 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny; 
            
            now++;
        }

        System.out.println((y+1) +  " " + (r-x));

    }

}
