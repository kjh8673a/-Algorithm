import java.util.*;
import java.io.*;

public class Main {
    static class Sushi {
        int rice;

        public Sushi(int time, int drink) {
            if (drink == 0 && time >= 12 && time <= 16) {
                rice = 320;
            } else {
                rice = 280;
            }
        }

        public int riceCount() {
            return rice;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        Sushi sushi = new Sushi(T, S);
        System.out.println(sushi.riceCount());
    }

}