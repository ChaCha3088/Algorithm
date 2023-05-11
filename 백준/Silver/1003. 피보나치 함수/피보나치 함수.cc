#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int T;
int input;
int arr[100];

void fibonacci(int n) {
    if (n != 0 && arr[n] == 0) {
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
    }
}


int main() {
    fastIo;

    arr[1] = 1;

    //입력
    cin >> T;

    for (int i = 0; i < T; ++i) {
        cin >> input;
        fibonacci(input);
        if (input == 0) {
            cout << 1 << " " << 0 << "\n";
        }
        else if (input == 1) {
            cout << 0 << " " << 1 << "\n";
        }
        else {
            cout << arr[input - 1] << " " << arr[input] << "\n";
        }
    }
}