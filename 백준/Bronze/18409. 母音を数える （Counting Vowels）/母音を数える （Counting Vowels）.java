
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'i', 'u', 'e', 'o'));

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(S.charAt(i))) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}
