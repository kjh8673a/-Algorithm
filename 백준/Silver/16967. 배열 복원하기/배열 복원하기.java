import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H+X][W+Y];

        for(int i = 0; i < H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W+Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = new int[H][W];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                ans[i][j] = arr[i][j];
            }
        }

        for(int i = X; i < H; i++) {
            for(int j = Y; j < W; j++) {
                ans[i][j] = arr[i][j] - ans[i-X][j-Y];
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(ans[i][j] + " ");
                if(j == W-1) sb.append("\n");
            }
        }
        
        System.out.println(sb.toString());

    }

}