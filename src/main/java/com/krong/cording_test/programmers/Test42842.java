package com.krong.cording_test.programmers;

public class Test42842 {

    //3의 배수여야한다.
    public int[] solution(int brown, int yellow) {
        int all = brown + yellow;
        int a = 3;
        int b = 0;
        while (a < all) {
            int mod = all%a;
            if(mod ==0) {
                b = all/a;
                if((a-2) * (b-2) >= yellow)
                    break;
            }
            a+=3;
        }
        if(a < b)
            return new int[]{b, a};
        else
            return new int[]{a, b};
    }

    public static void main(String[] args) {
        Test42842 solution = new Test42842();
        int[] answer = solution.solution(18, 6);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
