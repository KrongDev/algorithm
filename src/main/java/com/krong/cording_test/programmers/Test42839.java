package com.krong.cording_test.programmers;


import java.util.HashSet;
import java.util.Set;

public class Test42839 {
    private Set<Integer> set = new HashSet<>();
    private boolean[] visited;

    public void dfs(String numbers, String s, int depth) {
        //
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }


    public long solution(String numbers) {
        this.visited = new boolean[numbers.length()];

        dfs(numbers, "", 0);
        int answer = 0;
        for (Integer i : set) {
            if (isPrime(i)) answer++;
        }
        return answer;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String numbers = "17";
        Test42839 test = new Test42839();
        long a = test.solution(numbers);
        System.out.println(a);
    }
}
