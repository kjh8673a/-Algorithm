import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        System.out.println(Long.compare(N, M) == 0 ? 1 : 0);
    }

}