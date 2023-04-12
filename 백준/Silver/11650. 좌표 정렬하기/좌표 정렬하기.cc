#include <iostream>
#include <algorithm>
#include <vector>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

vector<pair<int, int>> v;

int main() {
    fastIo;

    //입력
    int N;
    cin >> N;

    int x, y;
    for (int i = 0; i < N; ++i) {
        cin >> x >> y;
        v.push_back({ x, y });
    }

    //정렬
    sort(v.begin(), v.end());

    //출력
    for (int i = 0; i < N; i++) {
        cout << v[i].first << ' ' << v[i].second << '\n';
    }

    return 0;
}