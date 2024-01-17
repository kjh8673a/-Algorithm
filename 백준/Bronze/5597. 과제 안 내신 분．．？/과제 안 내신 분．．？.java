import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i <= 30; i++) {
            treeSet.add(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            treeSet.remove(Integer.parseInt(br.readLine()));
        }

        treeSet.stream().forEach(System.out::println);
    }

}