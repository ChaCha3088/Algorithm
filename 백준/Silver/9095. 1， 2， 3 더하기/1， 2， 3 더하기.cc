#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int T;
int arr[11];
int input;

int main() {
    fastIo;

    //입력
    cin >> T;

    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;

    for (int i = 4; i <= 10; ++i) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }

    for (int i = 0; i < T; ++i) {
        cin >> input;

        cout << arr[input] << '\n';
    }
}