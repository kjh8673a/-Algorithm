import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i < 501; i++) {
            int node = i * i + n;
            int a = (int) Math.sqrt(node);

            if (a * a == node) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}