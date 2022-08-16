import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int front;
    static int rear;
    static int N;
    static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }

        for(int i = 1; i <= N; i++) {
            if(i == N) {
                System.out.println(que.poll());
            }else {
                que.poll();
            }            
            que.offer(que.poll());
        }
    
    }

}