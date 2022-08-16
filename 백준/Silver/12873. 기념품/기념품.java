import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        int idx = 1;
        while(!queue.isEmpty()) {
            long now = (long) Math.pow(idx, 3);
            now = now % queue.size();
            if(queue.size() == 1) {
                sb.append(queue.poll());
                break;
            }

            cnt++;

            if(now == 0) {
                now = queue.size();
            }
            if(cnt == now) {
                queue.poll();
                idx++;
                cnt = 0;
            }else {
                queue.offer(queue.poll());
            }

        }

        System.out.println(sb.toString());
    }

}