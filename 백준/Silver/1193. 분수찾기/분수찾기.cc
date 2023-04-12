#include <iostream>
#include <cmath>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    int X;
    cin >> X;

    int start = sqrt((2 * X));

    while (start * (start + 1) / 2 < X) {
        start++;
    }

    int diff = start * (start + 1) / 2 - X;

    if (start % 2 == 0) {
        cout << start - diff << "/" << 1 + diff;
    } else {
        cout << 1 + diff << "/" << start - diff;
    }

    return 0;
}