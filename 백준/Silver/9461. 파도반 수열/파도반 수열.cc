#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;

int T;
ll arr[101];
int input;

ll dp(int target) {
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;
    arr[4] = 2;

    for (int i = 5; i <= target; ++i) {
        arr[i] = arr[i - 2] + arr[i - 3];
    }

    return arr[target];
}

int main() {
    fastIo;

    //입력
    cin >> T;

    for (int i = 0; i < T; ++i) {
        cin >> input;

        cout << dp(input) << "\n";
    }
}