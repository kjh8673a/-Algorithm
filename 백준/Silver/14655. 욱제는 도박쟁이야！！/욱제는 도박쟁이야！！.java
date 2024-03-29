import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            max += Math.abs(Integer.parseInt(st.nextToken()));
        }

        int min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            min += Math.abs(Integer.parseInt(st.nextToken()));
        }

        System.out.println(max + min);
    }

}