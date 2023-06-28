import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Long> bldg = new Stack<>();
        long ans = 0;
        for(int i = 0; i < N; i++) {
            long h = Long.parseLong(br.readLine());
            while(!bldg.isEmpty() && bldg.peek() <= h) {
                bldg.pop();
            }
            ans += bldg.size();
            bldg.add(h);
        }

        System.out.println(ans);
    }

}
