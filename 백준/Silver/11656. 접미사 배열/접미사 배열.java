import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String s = br.readLine();

        TreeSet<String> set = new TreeSet<>();
        String suffix = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            suffix = ch + suffix;
            set.add(suffix);
        }

        set.stream().forEach(System.out::println);
    }

}
