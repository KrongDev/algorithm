package com.krong.cording_test.programmers;

import java.util.ArrayList;
import java.util.List;

public class Test84512 {
    private String[] keys = {"A", "E", "I", "O", "U"};
    private List<String> datas = new ArrayList<>();

    private void dps(String result) {
        if(result.length() > 5) return;
        datas.add(result);
        for(String k : keys) {
            dps(result + k);
        }
    }

    public int solution(String word) {
        int answer = 0;
        dps("");

        for(int i = 0; i < datas.size(); i++) {
            String s = datas.get(i);
//            if(s.length() == 5)
                System.out.println(i + " " + s);
        }
        return answer;
    }

    public int findIndex(char a) {
        int i = 0;
        for(String k: keys) {
            if(k.equals(String.valueOf(a))) break;
            i++;
        }
        return i;
    }

    /**
     * 1 = 781
     * 2 = 156
     * 3 = 31
     * 4 = 6
     * 5 = 1
     */
    int[] data = {781, 156, 31, 6, 1};

    public static void main(String[] args) {
        Test84512 test = new Test84512();
        String str = "UOE";
        test.solution(str);
        int answer = 0;
        for(int i = str.length() -1; i >= 0; i--) {
            int idx1 = test.findIndex(str.charAt(i));
            answer +=  ((idx1) * test.data[i]) + 1;
        }
        System.out.println(answer);
    }
}
