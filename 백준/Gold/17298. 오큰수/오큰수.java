import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] stack = new int[n];
        int top = -1;
        for(int i = 0; i < n; i++) {
            /*
             * 스택이 비어있지 않고,
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다
             */

            while(top != -1 && arr[stack[top]] < arr[i]) {
                arr[stack[top]] = arr[i];
                top--;
            }
            top++;
            stack[top] = i;

        }

        /*
         * 스택의 모든 원소를 인덱스로하는 배열의 값을 -1로 초기화한다
         */
        for(int i = top; i >= 0; i--) {
            arr[stack[i]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }

}