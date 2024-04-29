package com.krong.cording_test.programmers;

public class Test42842 {

    //3의 배수여야한다.
    public int[] solution(int brown, int yellow) {
        int all = brown + yellow;

        int x = 0;
        int y = 0;
        for(int i = all; i > 0; i--) {
            x = i;
            y = all/i;
            if(isYellowOk(x, y, yellow) && isAll(x, y, all)) break;
        }

        return makeAnswer(x, y);
    }

    private int mix(int x, int y) {
        return x * y;
    }

    private boolean isAll(int x, int y, int all) {
        return mix(x, y) == all;
    }

    private boolean isYellowOk(int x, int y, int yellow) {
        return mix(x-2, y-2) == yellow;
    }

    private int[] makeAnswer(int x, int y) {
        int[] answer = new int[2];
        answer[0] = Math.max(x, y);
        answer[1] = Math.min(x, y);
        return answer;
    }

    public static void main(String[] args) {
        Test42842 solution = new Test42842();
        int[] answer = solution.solution(10, 2);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
