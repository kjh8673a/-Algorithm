import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(Math.max(a, b));
        for (int i = a - 1; i >= 1; i--) {
            dq.addFirst(i);
        }
        for (int i = b - 1; i >= 1; i--) {
            dq.addLast(i);
        }

        if (dq.size() > N) {
            System.out.println(-1);
        } else {
            int cnt = N - dq.size();

            StringBuilder sb = new StringBuilder();
            sb.append(dq.pollFirst()).append(" ");
            for (int i = 0; i < cnt; i++) {
                sb.append(1).append(" ");
            }
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst()).append(" ");
            }

            System.out.println(sb);
        }

    }

}
