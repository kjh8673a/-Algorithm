import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int twoCnt = 0;
        int oneCnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            twoCnt += num / 2;
            oneCnt += num % 2;
        }

        if (twoCnt == oneCnt) {
            System.out.println("YES");
        } else if (oneCnt > twoCnt) {
            System.out.println("NO");
        } else {
            if ((twoCnt - oneCnt) % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

}