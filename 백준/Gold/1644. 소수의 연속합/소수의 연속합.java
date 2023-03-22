
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i < N + 1; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < N + 1; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N + 1; i++) {
            if (!isNotPrime[i]) {
                cnt++;
            }
        }

        int[] prime = new int[cnt];
        int idx = 0;
        for (int i = 0; i < N + 1; i++) {
            if (!isNotPrime[i]) {
                prime[idx++] = i;
            }
        }

        int ans = 0;
        int start = 0;
        int end = 0;
        int sum = (cnt > 0 ? prime[0] : 0);
        while (start <= end && end < cnt) {
            if (sum == N) {
                ans++;
                if (end == cnt - 1) {
                    break;
                }
                sum += prime[++end];
            } else if (sum < N) {
                if (end == cnt - 1) {
                    break;
                }
                sum += prime[++end];
            } else if (sum > N) {
                sum -= prime[start++];
            }
        }

        System.out.println(ans);
    }
}
