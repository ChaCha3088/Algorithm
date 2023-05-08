//1260-DFS와 BFS-Silver4-https://www.acmicpc.net/problem/1260

#include <iostream>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M, V;
int one, two;

vector<int> v[10001];

int dfsVisited[1001];
vector<int> dfsResult;
stack<int> dfsStack;

int bfsVisited[1001];
vector<int> bfsResult;

void dfs(int x) {
    //방문 기록
    dfsVisited[x] = 1;
    dfsResult.push_back(x);
    dfsStack.push(x);

    while (!dfsStack.empty()) {
        bool able = false;
        int t = dfsStack.top();

        for (int i = 0; i < v[t].size(); ++i) {
            //방문 기록이 없으면
            if (!dfsVisited[v[t][i]] == 1) {
                dfsResult.push_back(v[t][i]);
                dfsStack.push(v[t][i]);
                //방문 기록
                dfsVisited[v[t][i]] = 1;
                able = true;
                break;
            }
        }

        //이번에 한번도 방문하지 않으면
        if (!able) {
            dfsStack.pop();
        }
    }


}

void bfs(int start) {
    queue<int> q;
    q.push(start);

    //초기 방문 기록
    bfsVisited[start] = 1;

    while (!q.empty()) {
        int x = q.front();
        q.pop();

        //결과 기록
        bfsResult.push_back(x);

        for (int i = 0; i < v[x].size(); ++i) {
            //방문 기록이 없으면
            if (!bfsVisited[v[x][i]] == 1) {
                q.push(v[x][i]);

                //방문 기록
                bfsVisited[v[x][i]] = 1;
            }
        }
    }
}

int main() {
    fastIo;

    //입력
    cin >> N >> M >> V;

    for (int i = 0; i < M; ++i) {
        cin >> one >> two;

        v[one].push_back(two);
        v[two].push_back(one);
    }

    //정렬
    for (int i = 1; i <= N; ++i) {
        sort(v[i].begin(), v[i].end());
    }

    //dfs
    dfs(V);

    //bfs
    bfs(V);

    //출력
    //dfs
    for (int i = 0; i < dfsResult.size(); ++i){
        cout << dfsResult[i] << " ";
    }

    //bfs
    cout << '\n';
    for (int i = 0; i < bfsResult.size(); ++i){
        cout << bfsResult[i] << " ";
    }
}