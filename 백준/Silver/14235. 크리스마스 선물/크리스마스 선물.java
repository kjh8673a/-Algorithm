import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> gift = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a > 0) {
                for (int j = 0; j < a; j++) {
                    gift.add(Integer.parseInt(st.nextToken()));
                }
            } else {
                if (gift.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(gift.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}