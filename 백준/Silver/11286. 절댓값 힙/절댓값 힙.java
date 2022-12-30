import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = makePq();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            doPq(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb.toString());
    }

    public static void doPq(int n) {
        if (n != 0) {
            pq.add(n);
        } else {
            if (pq.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                sb.append(pq.poll()).append("\n");
            }
        }
    }

    public static PriorityQueue<Integer> makePq() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) != Math.abs(o2)) {
                    return Integer.compare(Math.abs(o1), Math.abs(o2));
                } else {
                    return Integer.compare(o1, o2);
                }
            }
        });
        return priorityQueue;
    }
}