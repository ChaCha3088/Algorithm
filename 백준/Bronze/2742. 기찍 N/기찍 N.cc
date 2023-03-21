#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    int *arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = N - i;
    }

    for (int i = 0; i < N; i++) {
        printf("%d ", arr[i]);

        if (i != N - 1) {
            printf("\n");
        }
    }

    return 0;
}