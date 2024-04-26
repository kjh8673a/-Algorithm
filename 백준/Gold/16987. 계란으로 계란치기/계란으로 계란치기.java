import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] durability, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        durability = new int[n];
        weight = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int cnt) {
        if (idx == n) {
            answer = Math.max(cnt, answer);
            return;
        }

        if (durability[idx] <= 0 || cnt == n - 1) {
            dfs(idx + 1, cnt);
            return;
        }

        int tmp = cnt;
        for (int i = 0; i < n; i++) {
            if (i == idx || durability[i] <= 0) {
                continue;
            }

            durability[i] -= weight[idx];
            durability[idx] -= weight[i];

            if (durability[i] <= 0) {
                tmp++;
            }
            if (durability[idx] <= 0) {
                tmp++;
            }

            dfs(idx + 1, tmp);

            durability[i] += weight[idx];
            durability[idx] += weight[i];
            tmp = cnt;
        }
    }

}