import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] after = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            after[i] = Integer.parseInt(st.nextToken());
        }

        int[] before = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (before[i] != after[i]) {
                ans++;
                for (int j = i; j < N && j < i + 3; j++) {
                    before[j] = Math.abs(before[j] - 1);
                }
            }
        }

        System.out.println(ans);
    }

}
