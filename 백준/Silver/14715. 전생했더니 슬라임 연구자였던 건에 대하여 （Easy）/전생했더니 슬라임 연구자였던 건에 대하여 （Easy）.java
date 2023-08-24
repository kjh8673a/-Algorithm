import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(K); i++) {
            while (K % i == 0) {
                cnt++;
                K /= i;
            }
        }
        if (K != 1) {
            cnt++;
        }

        int ans = 0;
        while (Math.pow(2, ans) < cnt) {
            ans++;
        }

        System.out.println(ans);
    }

}