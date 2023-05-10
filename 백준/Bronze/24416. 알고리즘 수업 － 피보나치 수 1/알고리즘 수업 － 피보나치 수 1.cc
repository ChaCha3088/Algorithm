#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int n;
int fibo[41];
int recCnt;
int dynCnt;

int rec(int input) {
    if (input == 1 || input == 2) {
        recCnt += 1;
        return 1;
    }
    else {
        return rec(input - 1) + rec(input - 2);
    }
}

int dyn(int input) {
    fibo[1] = 1;
    fibo[2] = 1;

    for (int i = 3; i <= input; ++i) {
        dynCnt += 1;
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    return fibo[input];
}

int main() {
    fastIo;

    //입력
    cin >> n;

    rec(n);
    dyn(n);
    cout << recCnt << " ";
    cout << dynCnt;
}