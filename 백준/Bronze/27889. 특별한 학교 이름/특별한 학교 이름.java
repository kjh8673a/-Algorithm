import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>() {
            {
                put("NLCS", "North London Collegiate School");
                put("BHA", "Branksome Hall Asia");
                put("KIS", "Korea International School");
                put("SJA", "St. Johnsbury Academy");
            }
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(map.get(str));
    }
}