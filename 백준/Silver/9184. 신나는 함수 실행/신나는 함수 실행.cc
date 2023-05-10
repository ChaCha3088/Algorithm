#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int a, b, c;
int arr[21][21][21];

int w(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1;
    }
    if (a > 20 || b > 20 || c > 20) {
        return w(20, 20, 20);
    }

    if (arr[a][b][c]) {
        return arr[a][b][c];
    }

    if (a < b && b < c) {
        arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        return arr[a][b][c];
    }
    else {
        arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return arr[a][b][c];
    }
}

int main() {
    fastIo;

    //입력
    cin >> a >> b >> c;

    while (!(a == -1 && b == -1 && c == -1)) {
        cout << "w(" << a << ", " << b << ", " << c << ") = ";
        cout << w(a, b, c) << "\n";

        cin >> a >> b >> c;
    }
}