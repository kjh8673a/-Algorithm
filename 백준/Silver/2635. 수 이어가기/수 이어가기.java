import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> ans = new ArrayList<>();

        int cnt = 0;
        for(int i = n; i >= n/2; i--) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(n);
            list.add(i);

            int tmp1 = n;
            int tmp2 = i;

            while(true) {
                int tmp3 = tmp1 - tmp2;

                if(tmp3 < 0) break;

                list.add(tmp3);

                tmp1 = tmp2;
                tmp2 = tmp3;
            }

            if(list.size() > cnt) {
                cnt = list.size();
                ans = list;
            }
        }

        sb.append(cnt).append("\n");

        for(int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i) + " ");
        }

        System.out.println(sb.toString());

    }

}
