import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> electronics = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            electronics.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        PriorityQueue<Integer> chargers = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            if (chargers.size() < m) {
                tmp = electronics.poll();
            } else {
                tmp = chargers.poll() + electronics.poll();
            }
            chargers.add(tmp);
            answer = Math.max(tmp, answer);
        }

        System.out.println(answer);
    }

}