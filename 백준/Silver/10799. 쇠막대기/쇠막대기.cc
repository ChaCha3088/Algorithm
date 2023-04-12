#include <iostream>
#include <stack>
#include <string>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    string a;
    cin >> a;

    int cnt = 0;
    stack<int> s;

    for (int i=0; i < a.size(); i++) {
        if (a[i] == '(')
            s.push(i);
        else {
            if (s.top() + 1 == i) {
                s.pop();
                cnt += s.size();
            }
            else {
                s.pop();
                ++cnt;
            }
        }
    }
    cout << cnt;
}

