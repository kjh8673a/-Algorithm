import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int time = a * 3600 + b * 60 + c;
        time += Integer.parseInt(br.readLine());

        int h = (time / 3600) % 24;
        time %= 3600;

        int m = time / 60;
        time %= 60;

        System.out.println(h + " " + m + " " + time);
    }

}