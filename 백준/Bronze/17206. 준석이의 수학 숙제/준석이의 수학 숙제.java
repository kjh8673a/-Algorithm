import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] que = new int[T];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            que[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, que[i]);
        }

        int[] memo = new int[max + 1];

        for (int i = 1; i < memo.length; i++) {
            memo[i] = memo[i - 1];
            if (i % 3 == 0) {
                memo[i] += i;
            } else if (i % 7 == 0) {
                memo[i] += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(memo[que[i]]).append("\n");
        }

        System.out.println(sb.toString());

    }

}