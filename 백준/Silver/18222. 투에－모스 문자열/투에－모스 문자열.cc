#include <iostream>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int recursive(ll k) {
    if (k == 0) {
        return 0;
    } else if (k == 1) {
        return 1;
    } else if (k % 2) {
        return 1 - recursive(k / 2);
    } else {
        return recursive(k / 2);
    }
}

int main() {
    fastIo;

    //입력
    ll k;
    cin >> k;

    cout << recursive(k - 1);
}