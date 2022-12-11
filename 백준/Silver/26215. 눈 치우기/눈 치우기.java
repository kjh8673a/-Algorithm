import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            if (a > max) {
                max = a;
            }
        }

        int ans = 0;
        if (sum > max * 2) {
            ans = sum / 2;
            if (sum % 2 != 0) {
                ans++;
            }
        } else {
            ans = max;
        }

        if (ans > 1440) {
            ans = -1;
        }

        System.out.println(ans);

    }

}