import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items);

        int answer = 0;
        int idx = 0;
        while (p < 200 && idx < n) {
            answer++;
            p += items[idx++];
        }

        System.out.println(answer);
    }

}