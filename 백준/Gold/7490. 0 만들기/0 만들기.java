import java.io.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            dfs(1, "");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, String exp) {
        String tmp = exp + String.valueOf(idx);
        if (idx == N) {
            if (cal(tmp) == 0) {
                sb.append(tmp).append("\n");
            }
            return;
        }

        dfs(idx + 1, tmp + " ");
        dfs(idx + 1, tmp + "+");
        dfs(idx + 1, tmp + "-");
    }

    private static int cal(String exp) {
        int sum = 0;
        char sign = '+';
        int prev = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 == 0) {
                prev = prev * 10 + (exp.charAt(i) - '0');
            }
            if (i % 2 == 1 || i == exp.length() - 1) {
                if (exp.charAt(i) != ' ') {
                    switch (sign) {
                        case '+':
                            sum += prev;
                            prev = 0;
                            break;
                        case '-':
                            sum -= prev;
                            prev = 0;
                            break;
                    }
                    sign = exp.charAt(i);
                }
            }
        }

        return sum;
    }

}
