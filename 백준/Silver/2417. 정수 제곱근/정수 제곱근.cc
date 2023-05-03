#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ull = unsigned long long;
using namespace std;

ull input;

ull squareRoot(ull n) {
    ull min = 0;
    ull max = 3037000500;
    ull guess;
    ull value;

    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        while (min <= max) {
            guess = (min + max) / 2;
            value = guess * guess;

            if (value == n)
                return guess;
            else if (value > n) {
                if ((guess - 1) * (guess - 1) < n) {
                    return guess;
                }
                max = guess - 1;
            } else {
                if ((guess + 1) * (guess + 1) > n) {
                    return guess + 1;
                }
                min = guess + 1;
            }
        }
    }
}

int main() {
    fastIo;

    //입력
    cin >> input;

    cout << squareRoot(input);
}