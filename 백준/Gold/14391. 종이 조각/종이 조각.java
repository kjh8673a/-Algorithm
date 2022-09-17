import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = num.charAt(j) - '0';
            }
        }

        ans = 0;

        solve(0, n, 0, m, 0);

        System.out.println(ans);

    }

    public static void solve(int top, int down, int left, int right, int sum) {
        if (top == down && left == down) {
            ans = Math.max(ans, sum);
            return;
        }

        if (top != down) {
            int tlr = 0;
            int dlr = 0;
            for (int i = left; i < right; i++) {
                tlr = tlr * 10 + arr[top][i];
            }
            for (int i = left; i < right; i++) {
                dlr = dlr * 10 + arr[down - 1][i];
            }

            solve(top + 1, down, left, right, sum + tlr);
            solve(top, down - 1, left, right, sum + dlr);
        }

        if (left != right) {
            int tld = 0;
            int trd = 0;
            for (int i = top; i < down; i++) {
                tld = tld * 10 + arr[i][left];
            }
            for (int i = top; i < down; i++) {
                trd = trd * 10 + arr[i][right - 1];
            }

            solve(top, down, left + 1, right, sum + tld);
            solve(top, down, left, right - 1, sum + trd);
        }

    }

}