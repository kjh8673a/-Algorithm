import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int cnt = set.size();

        int ans = 0;
        switch (game) {
            case "Y":
                ans = cnt;
                break;
            case "F":
                ans = cnt / 2;
                break;
            case "O":
                ans = cnt / 3;
                break;
        }

        System.out.println(ans);
    }

}
