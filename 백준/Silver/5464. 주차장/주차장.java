import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> empty_space = new PriorityQueue<>();
        int[] fare = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            fare[i] = Integer.parseInt(br.readLine());
            empty_space.add(i);
        }

        int[] cars = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            cars[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int[] parking = new int[m + 1];
        Queue<Integer> waiting = new LinkedList<>();
        for (int i = 0; i < m * 2; i++) {
            int data = Integer.parseInt(br.readLine());

            if (data > 0) {
                waiting.add(data);
            } else {
                empty_space.add(parking[data * -1]);
                parking[data * -1] = 0;
            }

            while (!waiting.isEmpty() && !empty_space.isEmpty()) {
                int car = waiting.poll();
                int spot = empty_space.poll();

                parking[car] = spot;
                answer += cars[car] * fare[spot];
            }
        }

        System.out.println(answer);
    }

}