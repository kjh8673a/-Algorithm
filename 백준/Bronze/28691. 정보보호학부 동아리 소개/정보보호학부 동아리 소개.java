import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>() {
            {
                put("M", "MatKor");
                put("W", "WiCys");
                put("C", "CyKor");
                put("A", "AlKor");
                put("$", "$clear");
            }
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(map.get(br.readLine()));
    }

}