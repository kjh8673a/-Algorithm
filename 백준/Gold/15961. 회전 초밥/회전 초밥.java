import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] check = new int[d + 1];
        int cnt = 0;
        int bonus = 0;
        for (int i = 0; i < k; i++) {
            if (check[sushi[i]] == 0) {
                cnt++;
            }
            check[sushi[i]]++;
        }
        if (check[c] == 0) {
            bonus = 1;
        }

        int ans = cnt + bonus;
        int left = 0;
        int right = k - 1;
        while (left < N) {
            check[sushi[left]]--;
            if (check[sushi[left]] == 0) {
                cnt--;
            }
            left++;

            right++;
            check[sushi[right % N]]++;
            if (check[sushi[right % N]] == 1) {
                cnt++;
            }

            if (check[c] == 0) {
                bonus = 1;
            } else {
                bonus = 0;
            }

            ans = Math.max(ans, cnt + bonus);
        }

        System.out.println(ans);
    }

}
