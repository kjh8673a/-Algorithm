import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split(" ");
        Arrays.stream(arr).forEach(num -> {
            sb.append(Integer.parseInt(num) - (l * p)).append(" ");
        });

        System.out.println(sb);
    }

}