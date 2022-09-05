import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> color;
    static Map<Integer, Integer> number;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        color = new HashMap<>();
        number = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String col = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            color.put(col, color.getOrDefault(col, 0) + 1);
            number.put(num, number.getOrDefault(num, 0) + 1);
        }
        
        ans = 0;
        
        if(rule1());
        else if(rule2());
        else if(rule3());
        else if(rule4());
        else if(rule5());
        else if(rule6());
        else if(rule7());
        else if(rule8());
        else if(rule9());

        System.out.println(ans);

    }

    public static boolean rule1() {
        if(color.size() == 1 && number.size() == 5) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                int chk = nKey - tmp;
                if(tmp != 0 && chk != 1) {
                    return false;
                }
                tmp = nKey;
            }
            ans = tmp + 900;
            return true;
        }
        return false;
    }

    public static boolean rule2() {
        if(number.size() == 2) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                if(number.get(nKey) != 1 && number.get(nKey) != 4) {
                    return false;
                }
                if(number.get(nKey) == 4) {
                    tmp = nKey;
                }
            }
            ans = tmp + 800;
            return true;
        }
        return false;
    }

    public static boolean rule3() {
        if(number.size() == 2) {
            int tmp2 = 0;
            int tmp3 = 0;
            for(int nKey : number.keySet()) {
                if(number.get(nKey) != 2 && number.get(nKey) != 3) {
                    return false;
                }
                if(number.get(nKey) == 3) {
                    tmp3 = nKey;
                }
                if(number.get(nKey) == 2) {
                    tmp2 = nKey;
                }
            }
            ans = tmp3 * 10 + tmp2 + 700;
            return true;
        }
        return false;
    }

    public static boolean rule4() {
        if(color.size() == 1) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                tmp = nKey;
            }
            ans = tmp + 600;
            return true;
        }
        return false;
    }

    public static boolean rule5() {
        if(number.size() == 5) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                int chk = nKey - tmp;
                if(tmp != 0 && chk != 1) {
                    return false;
                }
                tmp = nKey;
            }
            ans = tmp + 500;
            return true;
        }
        return false;
    }

    public static boolean rule6() {
        if(number.size() == 3) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                if(number.get(nKey) != 3 && number.get(nKey) != 1) {
                    return false;
                }
                if(number.get(nKey) == 3) {
                    tmp = nKey;
                }
            }
            ans = tmp + 400;
            return true;
        }
        return false;
    }

    public static boolean rule7() {
        if(number.size() == 3) {
            int tmp = 0;
            int tmp2 = 0;
            for(int nKey : number.keySet()) {
                if(number.get(nKey) != 2 && number.get(nKey) != 1) {
                    return false;
                }
                if(number.get(nKey) == 2) {
                    if(tmp != 0) {
                        tmp2 = nKey;
                    }else {
                        tmp = nKey;
                    }
                }
            }
            ans = tmp2 * 10 + tmp + 300;
            return true;
        }
        return false;
    }

    public static boolean rule8() {
        if(number.size() == 4) {
            int tmp = 0;
            for(int nKey : number.keySet()) {
                if(number.get(nKey) == 2) {
                    tmp = nKey;
                }
            }
            ans = tmp + 200;
            return true;
        }
        return false;
    }

    public static boolean rule9() {
        int tmp = 0;
        for(int nKey : number.keySet()) {
            tmp = nKey;
        }
        ans = tmp + 100;
        return true;
    }

}