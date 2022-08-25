import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());


            cnt = new int[41][2];
            
            int idx = 0;
            while(idx != n+1) {
                if(idx == 0) {
                    cnt[idx][0] = 1;
                    cnt[idx][1] = 0;
                } else {
                   cnt[idx][0] = cnt[idx-1][1];
                   cnt[idx][1] = cnt[idx-1][0] + cnt[idx-1][1];
                }
                idx++;
            }
            
            sb.append(cnt[n][0] + " " + cnt[n][1]).append("\n");
        }

        System.out.println(sb.toString());
    }

}