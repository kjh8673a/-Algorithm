import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] table = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        String rank = br.readLine();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            char c = rank.charAt(i);

            int prev = money[Math.max(i - 1, 0)];
            switch (c) {
                case 'B':
                    money[i] = table[0] - 1 - prev;
                    break;
                case 'S':
                    money[i] = table[1] - 1 - prev;
                    break;
                case 'G':
                    money[i] = table[2] - 1 - prev;
                    break;
                case 'P':
                    money[i] = table[3] - 1 - prev;
                    break;
                case 'D':
                    money[i] = table[3];
                    break;
            }
        }

        System.out.println(Arrays.stream(money).sum());
    }

}