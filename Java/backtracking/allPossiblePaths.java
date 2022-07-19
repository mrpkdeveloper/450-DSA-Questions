package Backtracking_And_Memoraization;

import java.util.ArrayList;
import java.util.List;

public class allPossiblePaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int len = graph.length;
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        List<Integer>[] adjList = new List[graph.length];
        for (int index = 0; index < len; index++) {
            adjList[index] = new ArrayList<>();
        }

        for (int index = 0; index < len; index++) {
            for (int col = 0; col < graph[index].length; col++) {
                adjList[index].add(graph[index][col]);
            }
        }
        helper.add(0);
        findPaths(0, len - 1, helper, answer, adjList);
        return answer;
    }

    private static void findPaths(int node, int targetNode, ArrayList<Integer> helper, List<List<Integer>> answer,
            List<Integer>[] adjList) {

        if (node == targetNode) {
            answer.add(new ArrayList<>(helper));
            return;
        }

        for (int nodes : adjList[node]) {
            helper.add(nodes);
            findPaths(nodes, targetNode, helper, answer, adjList);
            helper.remove(helper.size() - 1);
        }
    }

}
