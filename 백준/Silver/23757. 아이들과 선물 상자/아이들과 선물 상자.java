import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gifts.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int w = Integer.parseInt(st.nextToken());
            if (gifts.isEmpty()) {
                answer = 0;
                break;
            }

            int gift = gifts.poll();
            if (w > gift) {
                answer = 0;
                break;
            } else {
                if (gift - w > 0) {
                    gifts.add(gift - w);
                }
            }
        }

        System.out.println(answer);
    }
}