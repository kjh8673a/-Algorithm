import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] breed = new char[n + 1];
        for (int i = 1; i < n + 1; i++) {
            breed[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for (int i = 0; i < m; i++) {
            boolean tmp = true;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (breed[num] == 'P') {
                    tmp = false;
                }
            }
            if (tmp) {
                flag = true;
            }
        }

        System.out.println(flag ? "W" : "P");
    }
}