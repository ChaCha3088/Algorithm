#include <iostream>
using namespace std;

int main() {
    int N = 0;
    cin >> N;

    int input[1000] = {0, };
    double output[1000] = {0.0, };

    double max = 0.0;

    for (int i = 0; i < N; i++) {
        cin >> input[i];

        if (input[i] > max) {
            max = input[i];
        }

        output[i] = (double)input[i];
    }

    double sum = 0;

    for (int i = 0; i < N; i++) {
        double temp = output[i] / (1.0 * max) * 100.0;
        output[i] = temp;
        sum += output[i];
    }

    double divisor = (double)N;

    double avg = sum / divisor;

    cout << avg << endl;

    return 0;
}