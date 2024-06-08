import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> answer = new TreeSet<>();
        Set<String> set = new HashSet<>();

        String END = "000-00-0000";
        String ssn = "";
        while (!(ssn = br.readLine()).equals(END)) {
            if (set.contains(ssn)) {
                answer.add(ssn);
            } else {
                set.add(ssn);
            }
        }

        answer.stream().forEach(o -> System.out.println(o));
    }

}