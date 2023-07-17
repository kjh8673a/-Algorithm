import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            int now = line.charAt(i) - '0';
            while (!dq.isEmpty() && K > 0 && dq.getLast() < now) {
                dq.removeLast();
                K--;
            }
            dq.addLast(now);
        }

        StringBuilder sb = new StringBuilder();
        while (dq.size() > K) {
            sb.append(dq.removeFirst());
        }

        System.out.println(sb);
    }

}
