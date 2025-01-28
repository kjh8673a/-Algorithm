import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        int count = 2;

        while (count <= n && n != 1) {
            count += (6 * answer);
            answer++;
        }

        System.out.println(answer);
    }

}