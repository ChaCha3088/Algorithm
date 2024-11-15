import java.util.*;

class Solution {
    private int answer = 0;
    private int[] visited;
    private List<int[]>[] roads;
    
    public int solution(int N, int[][] road, int K) {
        // 초기화
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        visited[1] = 0;
        
        roads = new List[N + 1];
        
        for (int i = 1; i <= N; i++) {
            roads[i] = new ArrayList<int[]>();
        }
        
        // 입력
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int l = road[i][2];
            
            roads[a].add(new int[] {b, l});
            roads[b].add(new int[] {a, l});
        }
        
        // 탐색
        dijkstra();
        
        // K 이하인 마을의 개수 return
        for (int i = 1; i <= N; i++) {
            if (visited[i] <= K) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private void dijkstra() {
        // 출발지, 목적지, 거리
        Queue<int[]> queue = new LinkedList<>();
        
        // 초기 노드 삽입
        for (int[] element : roads[1]) {
            queue.offer(new int[] {1, element[0], element[1]});
        }
        
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            
            int newValue = visited[polled[0]] + polled[2];
            
            if (newValue < visited[polled[1]]) {
                visited[polled[1]] = newValue;
                
                for (int[] element : roads[polled[1]]) {
                    queue.offer(new int[] {polled[1], element[0], element[1]});
                }
            }
        }
    }
}