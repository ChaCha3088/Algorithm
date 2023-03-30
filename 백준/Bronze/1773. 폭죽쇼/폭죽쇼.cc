#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N = 0;
    int C = 0;

    cin>>N>>C;

    vector<int> cycle(C + 1);
    vector<int> input(N);

    for (int i = 0; i < N; i++) {
        cin>>input[i];
    }

    for (int i = 0; i < N; i++) {
        int current = input[i];
        int count = 1;

        while(true) {
            if (current * count > C) {
                break;
            }
            cycle[current * count] += 1;
            count++;
        }
    }

    int result = 0;

    for (int i = 1; i <= C; i++) {
        if (cycle[i] != 0) {
            result++;
        }
    }

    cout<<result<<endl;

    return 0;
}