import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        while (true) {
            if (K % 2 == 0) {
                if (K / 2 < A) {
                    break;
                } else {
                    K /= 2;
                    ans++;
                }
            } else {
                if (K - 1 < A) {
                    break;
                } else {
                    K -= 1;
                    ans++;
                }
            }
        }

        ans += K - A;

        System.out.println(ans);
    }

}
