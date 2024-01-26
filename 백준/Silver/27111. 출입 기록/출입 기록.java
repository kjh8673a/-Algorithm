import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> accessRecord = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 1) {
                if (accessRecord.contains(a)) {
                    answer++;
                } else {
                    accessRecord.add(a);
                }
            } else {
                if (accessRecord.contains(a)) {
                    accessRecord.remove(Integer.valueOf(a));
                } else {
                    answer++;
                }
            }
        }
        answer += accessRecord.size();

        System.out.println(answer);
    }

}