package com.krong.cording_test.programmers;

import com.krong.structure.linear.ArrayList;
import com.krong.structure.linear.List;

import java.util.Arrays;

public class Test86971 {

    ArrayList<Integer>[] graph;

    private int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
        return 0;
    }

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i <= n; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }



        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {

    }
}
