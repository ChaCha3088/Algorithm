#include <iostream>
#include <string>
#include <stack>
#include <sstream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N;
int ary[1000001];
int answer[1000001];
stack<int> s;

void split(string input, char delimiter) {
    stringstream ss(input);
    string tmp;
    int idx = 0;

    while (getline(ss, tmp, delimiter)) {
        ary[idx] = stoi(tmp, nullptr);
        ++idx;
    }
}

int main() {
    fastIo;

    //입력
    string input;

    cin >> N;
    cin.ignore();
    getline(cin, input);

    split(input, ' ');

    for (int i = N - 1; i >= 0; i--)
    {
        while (!s.empty() && s.top() <= ary[i])
            s.pop();

        if (s.empty()) answer[i] = -1;
        else answer[i] = s.top();

        s.push(ary[i]);
    }

    // 정답 출력
    for (int i = 0; i < N; i++) {
        cout << answer[i] << " ";
    }
}