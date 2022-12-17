import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 A의 크기

        // 입력받을 수열
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색을 통해 증가하는 수열을 저장
        int[] vector = new int[N];
        vector[0] = A[0];

        // 원래 수열이 각각 올 수 있는 위치를 저장
        int[] pos = new int[N];
        pos[0] = 0;

        int upper_bound = 0;

        for (int i = 1; i < N; i++) {
            int num = A[i];
            // 마지막 수보다 큰 경우 다음 위치에 수열에 추가
            if (num > vector[upper_bound]) {
                upper_bound++;
                vector[upper_bound] = num;
                pos[i] = upper_bound;
            }
            // 마지막 수보다 작은 경우 이분탐색을 통해 들어갈 위치를 탐색
            else {
                int r = lowerBound(vector, 0, upper_bound + 1, num);
                vector[r] = num;
                pos[i] = r;
            }
        }

        // 위치를 저장한 배열을 거꾸로 탐색하여
        // idx를 하나씩 줄여가며 적합한 답을 출력
        StringBuilder sb = new StringBuilder();
        sb.append(upper_bound + 1 + "\n");

        Stack<Integer> stack = new Stack<>();
        int idx = upper_bound;
        for (int i = N - 1; i >= 0; i--) {
            if (pos[i] == idx) {
                stack.push(A[i]);
                idx--;
            }
            if (idx == -1) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    public static int lowerBound(int[] arr, int left, int right, int key) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}