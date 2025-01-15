package com.krong.greedy;

import java.util.Arrays;

public class GreedyAlgorithm {
    private final String dia = "diamond";
    private final String iron = "iron";
    private final String stone = "stone";

    // 최소 condition을 반환 condition 가중치가 높으면 강도 높은 곡괭이 사용
    public int solution(int[] picks, String[] minerals) {
        int pickLen = picks[0] + picks[1] + picks[2];
        int mineralLen = minerals.length;

        int checkLen = Math.min(pickLen, mineralLen/5 + (mineralLen%5 > 0 ? 1 : 0) );
        // 컨디션 체크할 광물들 묶음
        int[][] mineralGroup = new int[checkLen][6];
        for(int i = 0; i < checkLen; i++) {
            int condition = 0;
            for(int j = 0; j < 5; j++) {
                if(i * 5 + j >= mineralLen) break;
                int damage = getCondition(minerals[i * 5 + j]);
                condition += damage;
                mineralGroup[i][((i * 5 + j)%5) + 1] += damage;
            }
            mineralGroup[i][0] = condition;
        }

        Arrays.sort(mineralGroup, (o1, o2) -> o2[0] - o1[0]);
        int answer = 0;
        // 컨디션 계산
        for(int i = 0; i < checkLen; i++) {
            int pick = 2;
            if(i < picks[0]) {
                pick = 0;
            } else if(i < picks[0] + picks[1]) {
                pick = 1;
            }
            for(int j = 1; j < 6; j++) {
                answer += getCondition(pick, mineralGroup[i][j]);
            }
        }
        return answer;
    }

    private int getCondition(int pick, int mineral) {
        switch (mineral) {
            case 25:
                return (int) Math.pow(5, pick);
            case 5:
                return (int) Math.pow(5, pick > 0 ? pick - 1 : pick);
            case 1:
                return 1;
        }
        return 0;
    }

    private int getCondition(String mineral) {
        switch (mineral) {
            case dia:
                return 25;
            case iron:
                return 5;
            case stone:
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] picks = {1, 0, 1};
        String[] minerals = {"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"};

        GreedyAlgorithm res = new GreedyAlgorithm();
        System.out.println(res.solution(picks, minerals));
    }
}
