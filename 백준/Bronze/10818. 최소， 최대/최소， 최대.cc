#include <iostream>
using namespace std;

int main() {
    int N;

    scanf("%d", &N);

    int input[N];

    for (int i = 0; i < N; i++) {
        scanf("%d", &input[i]);
    }

    int max = input[0];
    int min = input[0];

    for (int i = 0; i < N; i++) {
        if (input[i] > max) {
            max = input[i];
        }
        if (input[i] < min) {
            min = input[i];
        }
    }

    printf("%d %d", min, max);

    return 0;
}