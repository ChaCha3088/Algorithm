#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    int N;
    cin >> N;

    for (int i = 1; i <= N; i++) { // ex) N=5일때 i = 0 1 2 3 4
        for (int j = 0; j < N - i; j++) cout << " ";
        for (int k = 0; k <2*i -1; k++) cout << "*";
        cout << '\n';
    }

    for (int i = 1; i < N; i++) { //i=1 2 3 4
        for (int j = 0; j < i; j++) cout << " "; // j=0 01 012 0123
        for (int k = 0; k < 2 * N - (2 * i + 1); k++) cout << "*";
        cout << "\n";

    }

}