import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (n >= 10) {
            int tmp = 1;
            while (n > 0) {
                tmp *= n % 10;
                n /= 10;
            }
            n = tmp;
            answer++;
        }

        System.out.println(answer);
    }

}