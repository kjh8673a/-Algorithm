import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bessie_r = Integer.parseInt(st.nextToken());
        int bessie_c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int daisy_r = Integer.parseInt(st.nextToken());
        int daisy_c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int john_r = Integer.parseInt(st.nextToken());
        int john_c = Integer.parseInt(st.nextToken());

        int bessie_john = Math.max(Math.abs(bessie_r - john_r), Math.abs(bessie_c - john_c));
        int daisy_john = Math.abs(daisy_r - john_r) + Math.abs(daisy_c - john_c);

        if (bessie_john == daisy_john) {
            System.out.println("tie");
        } else if (bessie_john < daisy_john) {
            System.out.println("bessie");
        } else {
            System.out.println("daisy");
        }
    }

}