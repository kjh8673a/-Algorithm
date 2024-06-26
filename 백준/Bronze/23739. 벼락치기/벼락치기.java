import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int time = 30;
        for (int i = 0; i < n; i++) {
            int chapter = Integer.parseInt(br.readLine());
            if (chapter >= time) {
                if (chapter - time <= chapter / 2) {
                    answer++;
                }
                time = 30;
            } else {
                answer++;
                time -= chapter;
            }
        }

        System.out.println(answer);
    }

}