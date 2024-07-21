import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int mel = 0;

        st = new StringTokenizer(br.readLine());
        max += Integer.parseInt(st.nextToken()) * 3;
        max += Integer.parseInt(st.nextToken()) * 20;
        max += Integer.parseInt(st.nextToken()) * 120;

        st = new StringTokenizer(br.readLine());
        mel += Integer.parseInt(st.nextToken()) * 3;
        mel += Integer.parseInt(st.nextToken()) * 20;
        mel += Integer.parseInt(st.nextToken()) * 120;

        if (max > mel) {
            System.out.println("Max");
        } else if (max < mel) {
            System.out.println("Mel");
        } else {
            System.out.println("Draw");
        }
    }

}