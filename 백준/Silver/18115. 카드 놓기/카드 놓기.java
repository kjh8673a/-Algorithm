import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            int skill = arr[i];
            if (skill == 1) {
                dq.addFirst(N - i);
            } else if (skill == 2) {
                int tmp = dq.pollFirst();
                dq.addFirst(N - i);
                dq.addFirst(tmp);
            } else {
                dq.addLast(N - i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst() + " ");
        }

        System.out.println(sb);
    }

}