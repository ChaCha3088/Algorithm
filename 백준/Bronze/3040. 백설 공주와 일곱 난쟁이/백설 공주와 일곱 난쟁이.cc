#include <iostream>

using namespace std;

int main() {
    int input[9] = {0, };

    int sum = 0;

    for (int i = 0; i < 9; i++) {
        cin >> input[i];
        sum += input[i];
    }

    int overflow = sum - 100;

    for (int i = 8; i >= 0; i--) {
        for (int j = i - 1; j >= 0; j--) {
            if (input[i] + input[j] == overflow) {
                input[i] = 0;
                input[j] = 0;
                goto label;
            }
        }
    }
    
label:

    for (int i = 0; i < 9; i++) {
        if (input[i] != 0) {
            cout << input[i] << endl;
        }
    }

    return 0;
}