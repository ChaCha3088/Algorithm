#include <iostream>
#include <cmath>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

void hanoiPrint(int n, int from, int by, int to) {
    if (n == 1) {
        cout << from << " " << to << "\n";
    } else {
        hanoiPrint(n - 1, from, to, by);
        cout << from << " " << to << "\n";
        hanoiPrint(n - 1, by, from, to);
    }
}

int main() {
    fastIo;

    //입력
    int N;
    cin >> N;

    string a = to_string(pow(2, N));
    int x = a.find('.');
    a = a.substr(0,x);
    a[a.length() - 1] -= 1;
    cout << a << '\n';

    if (N <= 20) {
        hanoiPrint(N, 1, 2, 3);
    }
}