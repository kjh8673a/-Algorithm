import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Integer.parseInt(st.nextToken());
        double w = Integer.parseInt(st.nextToken());
        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        int a = (int) Math.ceil(h / (n + 1));
        int b = (int) Math.ceil(w / (m + 1));

        System.out.println(a * b);
    }

}
