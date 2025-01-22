import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] times = br.readLine().split(" ");
            int start = Integer.parseInt(times[0]) * 60 * 60 + Integer.parseInt(times[1]) * 60
                    + Integer.parseInt(times[2]);
            int end = Integer.parseInt(times[3]) * 60 * 60 + Integer.parseInt(times[4]) * 60
                    + Integer.parseInt(times[5]);

            int time = end - start;
            int h = time / (60 * 60);
            time %= (60 * 60);
            int m = time / 60;
            int s = time % 60;

            sb.append(h + " " + m + " " + s).append("\n");
        }

        System.out.println(sb.toString());
    }

}