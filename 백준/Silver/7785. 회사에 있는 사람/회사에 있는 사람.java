import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) {
                set.add(name);
            } else if (type.equals("leave") && set.contains(name)) {
                set.remove(name);
            }
        }

        set.stream().forEach(System.out::println);
    }

}