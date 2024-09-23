import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] pos = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 5; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 1; i < 5; i++) {
            if (pos[i] == x) {
                answer = i;
            }
        }

        System.out.println(answer);
    }

}