#include <iostream>
using namespace std;

int main() {
    int status = -1;
    int result[1001] = {0, };
    int count = 0;

    while (status != 0) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);

        if (a == 0 && b == 0 && c == 0) {
            status = 0;
            result[count] = 0;
        }
        else if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
            status = 1;
            result[count] = 1;
        }
        else {
            status = -1;
            result[count] = -1;
        }

        count++;
    }

    for (int i = 0; i < count - 1; i++) {
        if (result[i] == 1) {
            printf("%s", "right");
        } else if (result[i] == -1) {
            printf("%s", "wrong");
        }
        if (result[i+1] == 0) {
            break;
        }
        printf("\n");
    }


    return 0;
}