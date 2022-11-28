import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int ans = 0;
        int now = m;
        while(N > 0) {
            if(m + T > M) {
                ans = -1;
                break;
            }

            if(now + T <= M) {
                ans++;
                now += T;
                N--;
            }else {
                ans++;
                now -= R;
                if(now < m) {
                    now = m;
                }
            }
        }

        System.out.println(ans);

    }

}