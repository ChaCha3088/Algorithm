#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int house[1001][3];
int N;
int cost[3];

int main() {
    fastIo;

    house[0][0] = 0;
    house[0][1] = 0;
    house[0][2] = 0;

    //입력
    cin >> N;

    for (int i = 1; i <= N; ++i)
    {
        cin >> cost[0] >> cost[1] >> cost[2];

        house[i][0] = min(house[i-1][1], house[i-1][2]) + cost[0];
        house[i][1] = min(house[i-1][0], house[i-1][2]) + cost[1];
        house[i][2] = min(house[i-1][1], house[i-1][0]) + cost[2];
    }

    //출력
    cout << min(min(house[N][0], house[N][1]), house[N][2]);
}