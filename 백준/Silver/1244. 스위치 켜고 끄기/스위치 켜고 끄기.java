import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] swit = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            swit[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // 남학생 -> num의 배수 스위치 바꾸기
            if(gender == 1) {
                for(int j = 0; j < n; j++) {
                    if((j+1) % num == 0) {
                       swit[j] = (swit[j] == 0) ? 1 : 0;
                    }
                }
            }

            // 여학생 -> num부터 좌우로 하나씩 가면서 대칭인지 확인 후 바꾸기
            if(gender == 2) {
                // 일단 주어진 num에 해당하는 스위치 바꾸고 시작
                swit[num-1] = (swit[num-1] == 0) ? 1 : 0;

                // num에서 한칸 오른쪽부터 시작하여 대칭인 놈 체크
                for(int j = num; j < n; j++) {

                    // j와 주어진 num에 해당하는 스위치의 차이 -> j - 2*a가 j와 대칭인 놈
                    int a = j - (num - 1);

                    if(j - a * 2 < 0) break;

                    if(swit[j] == swit[j-a*2]) {
                        swit[j] = (swit[j] == 0) ? 1 : 0;
                        swit[j-a*2] = (swit[j-a*2] == 0) ? 1 : 0;
                    }else {
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            sb.append(swit[i] + " ");
            if((i+1) % 20 == 0 && i != 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }

}