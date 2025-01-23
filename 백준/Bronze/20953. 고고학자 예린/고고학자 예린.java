import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Long a = Long.parseLong(st.nextToken());
            Long b = Long.parseLong(st.nextToken());
            sb.append(dolmen(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long dolmen(long a, long b) {
        return (a + b) * (a + b) * (a + b - 1) / 2;
    }

}