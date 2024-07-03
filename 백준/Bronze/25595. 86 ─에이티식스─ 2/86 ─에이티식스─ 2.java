import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int nouzen = 0;
        List<int[]> regions = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    regions.add(new int[] { i, j });
                } else if (type == 2) {
                    nouzen = (i + j) % 2;
                }
            }
        }

        for (int[] region : regions) {
            if ((region[0] + region[1]) % 2 == nouzen) {
                System.out.println("Kiriya");
                return;
            }
        }

        System.out.println("Lena");
    }

}