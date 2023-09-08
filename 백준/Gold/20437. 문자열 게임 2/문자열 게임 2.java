import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            solve(W, K);
        }

        System.out.println(sb);
    }

    private static void solve(String w, int k) {
        if (k == 1) {
            sb.append("1 1").append("\n");
            return;
        }

        int[] arr = new int[26];

        for (int i = 0; i < w.length(); i++) {
            arr[w.charAt(i) - 'a']++;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < w.length(); i++) {
            char now = w.charAt(i);
            if (arr[now - 'a'] < k) {
                continue;
            }

            int cnt = 1;
            for (int j = i + 1; j < w.length(); j++) {
                if (w.charAt(j) == now) {
                    cnt++;
                }
                if (cnt == k) {
                    max = Math.max(max, j - i + 1);
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            sb.append(-1).append("\n");
        } else {
            sb.append(min + " " + max).append("\n");
        }
    }

}
