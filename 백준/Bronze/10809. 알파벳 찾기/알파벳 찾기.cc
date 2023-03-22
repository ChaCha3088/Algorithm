#include <iostream>
using namespace std;

int main() {
    char c[101] = {0, };
    cin >> c;

    int alphabet[26];
    for(int i = 0; i < 26; i++) {
        alphabet[i] = -1;
    }

    for (int i = 0; i < 101; i++) {
        int temp = c[i] - 'a';

        if (alphabet[temp] == -1) {
            alphabet[temp] = i;
        }

        if (c[i+1] == '\0') {
            break;
        }
    }

    for (int i = 0; i < 26; i++) {
        printf("%d ", alphabet[i]);
    }

    return 0;
}