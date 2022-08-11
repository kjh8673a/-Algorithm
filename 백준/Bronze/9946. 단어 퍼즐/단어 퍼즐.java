import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while(true) {
            sb.setLength(0);
            String a = br.readLine();
            String b = br.readLine();
            
            if(a.equals("END") && b.equals("END")) break;

            // 글자 길이가 다르다면 정렬할 것도 없이 바로 스킵
            if(a.length() != b.length()) {
                sb.append("Case " + idx + ": different");
                System.out.println(sb.toString());
                idx++;
                continue;
            }

            int[] arrA = new int[a.length()];
            int[] arrB = new int[b.length()];
            int maxA = Integer.MIN_VALUE;
            int maxB = Integer.MIN_VALUE;
            // 카운팅정렬을 하기 위해서 한글자씩 숫자로 바꿔서 배열에 넣어준다
            for(int i = 0; i < a.length(); i++) {
                arrA[i] = a.charAt(i)-97;
                arrB[i] = b.charAt(i)-97;
                maxA = Math.max(maxA, arrA[i]);
                maxB = Math.max(maxB, arrB[i]);
            }

            // arr의 value값을 index로 하는 counting 배열 값 1 증가
            int[] countingA = new int[maxA+1];
            for(int i = 0; i < arrA.length; i++) {
                countingA[arrA[i]]++; 
            }
            int[] countingB = new int[maxB+1];
            for(int i = 0; i < arrB.length; i++) {
                countingB[arrB[i]]++; 
            }

            // 누적합
            for(int i = 1; i < countingA.length; i++) {
                countingA[i] += countingA[i-1];
            }
            for(int i = 1; i < countingB.length; i++) {
                countingB[i] += countingB[i-1];
            }

            int[] resultA = new int[arrA.length];
            int[] resultB = new int[arrB.length];
            for(int i = arrA.length-1; i >= 0; i--) {
                countingA[arrA[i]]--;
                resultA[countingA[arrA[i]]] = arrA[i];
                countingB[arrB[i]]--;
                resultB[countingB[arrB[i]]] = arrB[i];
            }

            // 처음부터 끝까지 같은지 체크
            boolean check = true;
            for(int i = 0; i < resultA.length; i++) {
                if(resultA[i] != resultB[i]) {
                    check = false;
                    break;
                }
            }

            if(check == true) {
                sb.append("Case " + idx + ": same");
            }else {
                sb.append("Case " + idx + ": different");
            }
            System.out.println(sb.toString());

            idx++;
        }

    }

}