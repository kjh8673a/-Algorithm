import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        boolean isPossible = false;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < H; i++) {
            int p = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                int a = Integer.parseInt(st.nextToken());

                if(p * N <= B && a > N) {
                    isPossible = true;
                    min = Math.min(min, p * N);
                }
            }
        }

        if(isPossible) {
            System.out.println(min);
        }else {
            System.out.println("stay home");
        }

    }

}