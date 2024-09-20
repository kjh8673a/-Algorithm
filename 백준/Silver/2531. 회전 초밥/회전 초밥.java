import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushiQueue = new int[n];
        for (int i = 0; i < n; i++) {
            sushiQueue[i] = Integer.parseInt(br.readLine());
        }

        int[] checkSushi = new int[d + 1];
        int count = 0;
        for (int i = n - k; i < n; i++) {
            if (++checkSushi[sushiQueue[i]] == 1) {
                count++;
            }
        }
        if (checkSushi[c] == 0) {
            count++;
        }

        int answer = count;
        int prev = n - k;
        for (int i = 0; i < n; i++) {
            if (checkSushi[c] == 0) {
                count--;
            }

            if (++checkSushi[sushiQueue[i]] == 1) {
                count++;
            }

            if (--checkSushi[sushiQueue[prev++]] == 0) {
                count--;
            }
            if (prev == n) {
                prev = 0;
            }

            if (checkSushi[c] == 0) {
                count++;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

}