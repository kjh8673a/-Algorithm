import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> mimList = new ArrayList<>();
        mimList.add("Never gonna give you up");
        mimList.add("Never gonna let you down");
        mimList.add("Never gonna run around and desert you");
        mimList.add("Never gonna make you cry");
        mimList.add("Never gonna say goodbye");
        mimList.add("Never gonna tell a lie and hurt you");
        mimList.add("Never gonna stop");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (!mimList.contains(line)) {
                flag = false;
            }
        }

        System.out.println(flag ? "No" : "Yes");
    }
}