#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int arr[1000001];
int input;

int dyn(int target) {
    arr[1] = 1;
    arr[2] = 2;

    for (int i = 3; i <= target; ++i) {
        arr[i] = arr[i - 1] + arr[i - 2];
        arr[i] %= 15746;
    }

    return arr[target];
}

int main() {
    fastIo;

    //입력
    cin >> input;

    cout << dyn(input);
}