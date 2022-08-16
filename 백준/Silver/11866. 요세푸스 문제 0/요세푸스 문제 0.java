import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int cnt = 0;
        while(!queue.isEmpty()) {
            cnt++;
            if(cnt == K) {
                if(queue.size() == 1) {
                    sb.append(queue.poll());
                    break;
                }
                sb.append(queue.poll() + ", ");
                cnt = 0;
            }else {
                queue.offer(queue.poll());
            }
        }

        sb.append(">");

        System.out.println(sb.toString());
        

    }


}