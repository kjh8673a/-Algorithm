import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        ans = -1;
        bfs(A, B);

        System.out.println(ans);
    }

    public static void bfs(long a, long b) {
        Queue<Long> queue = new LinkedList<>();

        queue.add(a);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                long num = queue.poll();

                if (num == b) {
                    ans = cnt;
                    return;
                }

                if (num * 2 <= b) {
                    queue.add(num * 2);
                }
                if (num * 10 + 1 <= b) {
                    queue.add(num * 10 + 1);
                }
            }

        }
    }

}