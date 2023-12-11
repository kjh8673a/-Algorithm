import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int position = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            position += Integer.parseInt(st.nextToken());
        }

        System.out.println(position == 0 ? "Stay" : (position > 0 ? "Right" : "Left"));
    }

}