#include <iostream>
#include <algorithm>
#include <cmath>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;

int N;
int input;
ll maxValue;
ll arr[301];
ll sumArr[301];

int dp(int target) {

    for (int i = 4; i <= target; ++i) {
        cin >> input;
        arr[i] = input;
        maxValue = max(sumArr[i - 2], sumArr[i - 3] + arr[i - 1]);
        maxValue += input;
        sumArr[i] = maxValue;
    }

    return maxValue;
}

int main() {
    fastIo;

    //입력
    cin >> N;

    cin >> input;
    sumArr[1] = input;
    arr[1] = input;

    cin >> input;
    arr[2] = input;
    int num = sumArr[1] + input;
    sumArr[2] = max(num, input);

    cin >> input;
    arr[3] = input;
    sumArr[3] = max(arr[2] + input, arr[1] + input);

    if (N >= 4) {
        cout << dp(N);
    } else {
        cout << sumArr[N];
    }
}