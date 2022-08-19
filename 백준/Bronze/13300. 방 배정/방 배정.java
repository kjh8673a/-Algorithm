import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Double> student = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            String key = "";
            if(gender == 0) {
                key += "F" + grade;
            }else {
                key += "M" + grade;
            }
            student.put(key, student.getOrDefault(key, (double) 0) + 1);
        }

        int ans = 0;

        for(int i = 1; i <= 6; i++) {
            if(student.containsKey("F" + i)) {
                ans += Math.ceil(student.get("F" + i) / k);
            }

            if(student.containsKey("M" + i)) {
                ans += Math.ceil(student.get("M" + i) / k);
            }
        }

        System.out.println(ans);
        
    }

}