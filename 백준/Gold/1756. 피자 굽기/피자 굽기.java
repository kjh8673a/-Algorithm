import java.io.*;
import java.util.*;

public class Main {
    static int D, N, pos;
    static int[] oven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken()); // 오븐의 깊이
        N = Integer.parseInt(st.nextToken()); // 피자 반죽의 개수

        oven = new int[D + 1];
        st = new StringTokenizer(br.readLine());
        oven[0] = Integer.MAX_VALUE;
        for (int i = 1; i < D + 1; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            oven[i] = Math.min(oven[i - 1], oven[i]);
        }

        st = new StringTokenizer(br.readLine());
        pos = D;
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(st.nextToken());
            dropPizza(size);
        }

        System.out.println(pos);
    }

    private static void dropPizza(int size) {
        boolean flag = false;

        for (int i = pos; i > 0; i--) {
            if (size <= oven[i]) {
                pos = i;
                oven[i] = 0;
                flag = true;
                break;
            }
        }

        if (!flag) {
            pos = 0;
        }
    }

}
