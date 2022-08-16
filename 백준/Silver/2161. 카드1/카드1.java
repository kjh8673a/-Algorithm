import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int front;
    static int rear;
    static int N;
    static int[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        queue = new int[N];
        front = rear = 0;

        for(int i = 1; i <= N; i++) {
            enQueue(i);
        }

        for(int i = 1; i <= N; i++) {
            sb.append(deQueue() + " ");
            enQueue(deQueue());
        }
        
        System.out.println(sb.toString());

    }

    public static boolean isEmpty() {
        return front == rear;
    }

    public static boolean isFull() {
        return rear == queue.length-1;
    }

    public static void enQueue(int item) {
        rear = (rear+1) % N;
        queue[rear] = item;
    }

    public static int deQueue() {
        front = (front+1) % N;
        return queue[front];
    }

}