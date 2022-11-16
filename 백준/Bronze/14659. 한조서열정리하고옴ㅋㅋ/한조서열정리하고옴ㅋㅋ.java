import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        int tmp = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (num > now) {
                tmp++;
                if (i == N - 1) {
                    ans = Math.max(ans, tmp);
                }
            } else {
                ans = Math.max(ans, tmp);
                num = now;
                tmp = 0;
            }
        }

        System.out.println(ans);

    }

}