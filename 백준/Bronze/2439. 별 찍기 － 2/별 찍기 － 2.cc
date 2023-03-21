#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        char c[N];

        for (int j = 0; j < N; j++) {
            if (j >= (N - i - 1)) {
                c[j] = '*';
            } else {
                c[j] = ' ';
            }
        }

        for (int j = 0; j < N; j++) {
            printf("%c", c[j]);
        }

        if (i != N - 1) {
            printf("\n");
        }
    }

    return 0;
}