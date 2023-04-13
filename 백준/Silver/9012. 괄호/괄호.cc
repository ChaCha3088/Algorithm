#include <iostream>
#include <stack>
#include <string>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    int T;
    cin >> T;

    for (int i = 0; i < T; ++i) {
        string str;
        cin >> str;

        stack <char> s;
        s.push(str[0]);

        for (int j = 1; j < str.size(); ++j) {
            if (s.empty()) {
                if (str[j] == '(') {
                    s.push(str[j]);
                } else {
                    goto fail;
                }
            } else if (s.top() == '(' & str[j] == ')') {
                s.pop();
            } else {
                s.push(str[j]);
            }
        }

        //출력
        if (s.empty()) {
            cout << "YES" << "\n";
        } else {
            fail:
                cout << "NO" << "\n";
        }
    }
}