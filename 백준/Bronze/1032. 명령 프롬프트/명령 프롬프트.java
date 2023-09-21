import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        boolean[] chk = new boolean[arr[0].length()];
        Arrays.fill(chk, true);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                if (arr[0].charAt(j) != arr[i].charAt(j)) {
                    chk[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[0].length(); i++) {
            if (chk[i]) {
                sb.append(arr[0].charAt(i));
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }

}
