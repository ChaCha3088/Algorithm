#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <string>
#include <queue>
#include <unordered_set>
#include <set>
#include <unordered_map>
#include <map>
#include <tuple>
#include <cmath>
#include <numeric>
#include <limits>

#define MOD 1000000007
using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

string bunch[11];
int baseChangeCount;

int main() {
    fastIo;
    
    //입력
    int N;
    cin >> N;

    //입력을 받고, 전구 묶음의 총 변화 횟수를 구한다.
    for (int i = 0; i < N; ++i) {
        cin >> bunch[i];
        char initChar = bunch[i][0];

        for (int j = 0; j < bunch[i].length(); ++j) {
            if (initChar != bunch[i][j])
                baseChangeCount += 1;
            initChar = bunch[i][j];
        }
    }

    //순열을 위해 정렬한다.
    sort(bunch, bunch + N);

    //순열을 돌면서 전구 묶음의 총 변화 횟수의 최솟값를 구한다.
    int answer = numeric_limits<int>().max();
    do {
        int temp = baseChangeCount;
        for (int i = 0; i < N - 1; ++i) {
            if (bunch[i][bunch[i].length() - 1] != bunch[i + 1][0])
                temp += 1;
        }
        answer = min(answer, temp);
    } while (next_permutation(bunch, bunch + N));

    //출력
    cout << answer;
}