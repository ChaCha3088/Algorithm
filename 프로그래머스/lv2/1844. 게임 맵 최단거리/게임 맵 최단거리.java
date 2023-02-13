import java.util.*;

class Solution {
    int[][] maps, visited;
    int m, n;
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        this.maps = maps;
        
        bfs();
        
        if (visited[m - 1][n - 1] == 0) {
            return -1;
        } else {
            return visited[m - 1][n - 1];     
        }
    }
        
    private void bfs() {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            int[] remove = queue.remove();
            int y = remove[0];
            int x = remove[1];
            
            for (int i = 0; i < 4; i++) {
                var nx = x + dx[i];
                var ny = y + dy[i];
                
                //벽에 닿는거
                if (ny >= m || ny < 0 || nx >= n || nx < 0) continue;
                
                //안가봤고, 갈 수 있으면
                if (visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    //기록
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}