import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크레인
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());

        // 박스
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());

        int ans = 0;
        if (crane.get(0) < box.get(0)) {
            ans = -1;
        } else {
            while (!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < crane.size();) {
                    if (idx == box.size()) {
                        break;
                    } else if (crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else {
                        idx++;
                    }
                }
                ans++;
            }
        }

        System.out.println(ans);

    }
}
