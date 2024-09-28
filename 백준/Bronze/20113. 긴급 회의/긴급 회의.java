import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] vote = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            vote[x]++;
        }

        int winner = 0;
        int count = vote[0];
        boolean same = false;
        for (int i = 1; i < n + 1; i++) {
            if (vote[i] > count) {
                winner = i;
                count = vote[i];
                same = false;
            } else if (vote[i] == count) {
                if (winner == 0) {
                    winner = i;
                } else {
                    same = true;
                }
            }
        }

        if (same || winner == 0) {
            System.out.println("skipped");
        } else {
            System.out.println(winner);
        }
    }

}