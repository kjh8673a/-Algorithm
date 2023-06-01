import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] pre = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            int[] in = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            String ans = solve(0, n - 1, pre, 0, n - 1, in);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }

    private static String solve(int pre_left, int pre_right, int[] pre, int in_left, int in_right, int[] in) {
        String root = String.valueOf(pre[pre_left]) + " ";
        String left = "";
        String right = "";

        if (pre_left != pre_right) {
            int index = in_left;
            for (int i = in_left; i < in_right; i++) {
                if (in[i] == pre[pre_left]) {
                    index = i;
                    break;
                }
            }
            int len = index - in_left;

            if (index != in_left) {
                left = solve(pre_left + 1, pre_left + len, pre, in_left, index - 1, in);
            }

            if (index != in_right) {
                right = solve(pre_left + len + 1, pre_right, pre, index + 1, in_right, in);
            }
        }

        return left + right + root;
    }

}