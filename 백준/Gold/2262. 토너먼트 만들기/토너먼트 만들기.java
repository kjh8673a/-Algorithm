import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int rank = Integer.parseInt(st.nextToken());
            pq.add(rank);
            list.add(rank);
        }

        int answer = 0;
        while (pq.size() > 1) {
            int max = pq.poll();
            int idx = list.indexOf(max);

            int left = idx > 0 ? list.get(idx - 1) : 0;
            int right = idx < list.size() - 1 ? list.get(idx + 1) : 0;

            answer += (max - Math.max(left, right));
            list.remove(idx);
        }

        System.out.println(answer);
    }

}