import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        boolean[] check = new boolean[1000001];
        check[0] = check[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!check[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    check[j] = true;
                }
            }
        }

        Queue<Long> queue = new LinkedList<>();
        for (long i = 2; i * i <= N; i++) {
            if (!check[(int) i]) {
                while (N % i == 0) {
                    queue.add(i);
                    N /= i;
                }
            }
        }

        if (N != 1) {
            queue.add(N);
        }

        StringBuilder sb = new StringBuilder();
        if (queue.size() > 1) {
            while (!queue.isEmpty()) {
                long tmp = queue.poll() * queue.poll();
                if (queue.size() == 1) {
                    tmp *= queue.poll();
                }
                sb.append(tmp + " ");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }

    }

}