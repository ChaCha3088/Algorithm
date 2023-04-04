#include <iostream>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

ll r, c;
ll result = 0;

void recursive(int length) {
    int half = length / 2;
    int add = length * length / 4;

    if (r < half && c < half) {
        if (r == 0 && c == 0) {
            return;
        }
    } else if (r < half && c >= half) {
        result += add;

        if (r == 0 && c == half) {
            return;
        }
        c -= half;
    } else if (r >= half && c < half) {
        result += add * 2;

        if (c == 0 && r == half) {
            return;
        }
        r -= half;
    } else if (r >= half && c >= half) {
        result += add * 3;

        if (r == half && c == half) {
            return;
        }
        r -= half;
        c -= half;
    }

    if (length <= 2) {
        return;
    }

    recursive(half);
}

int main() {
    fastIo;

    //입력
    int N;

    cin >> N >> r >> c;

    recursive(1 << N);

    cout << result;
}