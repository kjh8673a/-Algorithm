import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>() {
            {
                put("NLCS", "North London Collegiate School");
                put("BHA", "Branksome Hall Asia");
                put("KIS", "Korea International School");
                put("SJA", "St. Johnsbury Academy");
            };
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(map.get(br.readLine()));
    }

}