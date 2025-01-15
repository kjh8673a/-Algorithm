import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> remains = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            remains.add(a % 42);
        }

        System.out.println(remains.size());
    }

}