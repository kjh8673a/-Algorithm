import java.io.*;
import java.util.*;

public class Main {
    static int[] constraints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        constraints = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());
            for (int j = 0; j < z; j++) {
                constraints[i] |= (1 << (Integer.parseInt(st.nextToken()) - 1));
            }
        }

        int answer = 0;
        for (int i = 0; i < (1 << t); i++) {
            if (isPossible(i)) {
                answer++;
            }

        }

        System.out.println(answer);
    }

    private static boolean isPossible(int comb) {
        for (int i = 0; i < constraints.length; i++) {
            if ((comb & constraints[i]) == constraints[i]) {
                return false;
            }
        }
        return true;
    }

}