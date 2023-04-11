import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[] day = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        int sum = 0;
        for (int i = 0; i < x; i++) {
            switch (i) {
                case 0:
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sum += 30;
                    break;
                case 2:
                    sum += 28;
                    break;
            }
        }

        sum += y;

        System.out.println(day[(sum - 1) % 7]);

    }
}
