import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static Node[] arr;
    static int ans;
    static boolean[] visit;

    static class Node {
        char start;
        char end;
        int change;

        public Node(char start, char end, int change) {
            this.start = start;
            this.end = end;
            this.change = change;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int cnt = 0;
            char ch = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                if (ch != str.charAt(j)) {
                    ch = str.charAt(j);
                    cnt++;
                }
            }
            arr[i] = new Node(str.charAt(0), str.charAt(str.length() - 1), cnt);
        }
        ans = Integer.MAX_VALUE;
        visit = new boolean[N];
        dfs(0, '0', 0);
        System.out.println(ans);
    }

    public static void dfs(int cnt, char end, int change) {
        if (cnt == N) {
            ans = Math.min(ans, change);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (cnt == 0) {
                    dfs(cnt + 1, arr[i].end, arr[i].change);
                } else {
                    if (end == arr[i].start) {
                        dfs(cnt + 1, arr[i].end, change + arr[i].change);
                    } else {
                        dfs(cnt + 1, arr[i].end, change + arr[i].change + 1);
                    }
                }
                visit[i] = false;
            }
        }
    }

}