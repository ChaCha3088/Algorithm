#include <iostream>
#include <cmath>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ull = unsigned long long;
using namespace std;

ull input;
ull answer;

int main() {
    fastIo;

    //입력
    cin >> input;

    ull result = sqrt(input);

    if (result * result < input) {
        answer = result + 1;
    } else {
        answer = result;
    }

    cout << answer;
}
