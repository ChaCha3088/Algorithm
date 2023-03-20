#include <iostream>
using namespace std;

int main() {
    int N;

    scanf("%d", &N);

    for (int j = 0; j < N; j++) {
        int sum = 0;
        int count = 0;

        char input[81];
        scanf("%s", input);

        int i = 0;

        while (input[i] != '\0') {
            if (input[i] == 'O') {
                count++;
                sum += count;
            }
            else {
                count = 0;
                sum += count;
            }
            i++;
        }

        printf("%d", sum);
        printf("\n");
    }

    return 0;
}