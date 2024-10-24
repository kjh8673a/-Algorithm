import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ab = Integer.parseInt(st.nextToken());
        int bc = Integer.parseInt(st.nextToken());
        int cd = Integer.parseInt(st.nextToken());

        double da = (double) ab * cd / bc;
        System.out.println(String.format("%6f", da));
    }

}