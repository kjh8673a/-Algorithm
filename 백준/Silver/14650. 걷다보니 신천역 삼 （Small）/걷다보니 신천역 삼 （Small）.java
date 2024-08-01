import java.io.*;

public class Main {
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        answer = 0;
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum % 3 == 0) {
                answer++;
            }
            return;
        }
        if (depth != 0) {
            dfs(depth + 1, sum + 0);
        }
        dfs(depth + 1, sum + 1);
        dfs(depth + 1, sum + 2);
    }

}