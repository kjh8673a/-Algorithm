import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        double ans = W * H / 2;

        System.out.println(String.format("%.1f", ans));
    }

}
