import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> bulb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력받는 수열
        int[] button = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            button[i] = Integer.parseInt(st.nextToken());
        }

        // 수열 값들의 우선순위 설정
        bulb = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            bulb.put(Integer.parseInt(st.nextToken()), i);
        }

        // 증가하는 수열을 저장할 배열
        int[] vector = new int[n];
        vector[0] = button[0];

        // 원래 수열이 각각 올 수 있는 위치를 저장할 배열
        int[] pos = new int[n];
        pos[0] = 0;

        int upper_bound = 0;
        for (int i = 1; i < n; i++) {
            int num = button[i];

            // 마지막 수보다 큰 경우 다음 위치에 추가
            if (bulb.get(num) > bulb.get(vector[upper_bound])) {
                upper_bound++;
                vector[upper_bound] = num;
                pos[i] = upper_bound;
            }
            // 마지막 수보다 작은 경우 이분탐색을 통해 들어갈 위치 탐색
            else {
                int r = lowerBound(vector, 0, upper_bound + 1, num);
                vector[r] = num;
                pos[i] = r;
            }
        }

        List<Integer> list = new ArrayList<>();
        int idx = upper_bound;
        for (int i = n - 1; i >= 0; i--) {
            if (pos[i] == idx) {
                list.add(button[i]);
                idx--;
            }
            if (idx == -1) {
                break;
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(upper_bound + 1).append("\n");
        list.stream().forEach(num -> sb.append(num + " "));

        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int left, int right, int key) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (bulb.get(arr[mid]) < bulb.get(key)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}