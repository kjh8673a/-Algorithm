import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double ab = Double.parseDouble(st.nextToken());
        double bc = Double.parseDouble(st.nextToken());
        double cd = Double.parseDouble(st.nextToken());

        System.out.println(ab * cd / bc);
    }

}