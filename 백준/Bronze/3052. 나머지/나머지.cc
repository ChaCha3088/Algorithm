#include <iostream>
using namespace std;

int main() {
    int input[10] = {0, };
    for (int i = 0; i < 10; i++) {
        int temp = 0;
        scanf("%d", &temp);

        input[i] = temp % 42;
    }

    int result[42] = {0, };
    for (int i = 0; i < 10; i++) {
        result[input[i]]++;
    }

    int count = 0;
    for (int i = 0; i < 42; i++) {
        if (result[i] != 0) {
            count++;
        }
    }

    printf("%d", count);

    return 0;
}