import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];
        
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        
        while (bfs.size() > 0) { // 2~n까지 도착하는 경로 구하기
            int nowNode = bfs.poll();
            List<Integer> node = graph.get(nowNode);
            for(int i = 0; i < node.size(); i++) {
                if (visited[node.get(i)] == false) {
                    bfs.add(node.get(i));
                    visited[node.get(i)] = true;
                    distance[node.get(i)] = distance[nowNode] + 1; 
                }      
            }  
        }
        
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        
        for(int i = distance.length-1; distance[i] == max; i--)
            answer++;
        
        return answer;
    }
}