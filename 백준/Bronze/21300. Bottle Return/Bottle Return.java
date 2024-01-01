import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < 6; i++) {
            answer += Integer.parseInt(st.nextToken()) * 5;
        }

        System.out.println(answer);
    }

}