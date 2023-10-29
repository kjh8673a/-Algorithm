import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            queue.add(i);
        }

        int[] ans = new int[N];
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int idx = queue.poll();
            arr[idx]--;
            if (arr[idx] == 0) {
                ans[idx] = time;
            }
            if (arr[idx] > 0) {
                queue.add(idx);
            }
        }

        IntStream.of(ans).forEach(a -> System.out.print(a + " "));
    }

}
