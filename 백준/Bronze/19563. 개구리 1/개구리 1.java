import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Math.abs(Integer.parseInt(st.nextToken()));
        int b = Math.abs(Integer.parseInt(st.nextToken()));
        int c = Integer.parseInt(st.nextToken());

        if (a + b > c) {
            System.out.println("NO");
        } else if ((a + b) % 2 == c % 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}