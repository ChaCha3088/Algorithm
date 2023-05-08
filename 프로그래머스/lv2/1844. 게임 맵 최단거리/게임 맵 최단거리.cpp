#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> map;
int visited[101][101] = {0, };
int m, n;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int bfs() {
    queue<pair<int, int>> q;
    q.push({0, 0});

    while (q.size() > 0) {
        pair<int, int> p = q.front();
        q.pop();

        int x = p.first;
        int y = p.second;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽에 닿으면, 반복문 끝
            if (ny >=m || nx >= n || ny < 0 || nx < 0) {
                continue;
            }

            //안가봤고, 갈 수 있는 곳이면
            if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                //방문 기록
                visited[ny][nx] = visited[y][x] + 1;
                q.push({nx, ny});
            }
        }
    }

    return visited[m - 1][n - 1];
}

int solution(vector<vector<int>> maps)
{
    visited[0][0] = 1;

    m = maps.size();
    n = maps[0].size();

    map = maps;

    int answer = bfs();

    if (answer == 0) {
        return -1;
    } else {
        return answer;
    }
}