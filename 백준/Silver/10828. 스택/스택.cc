#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

class Stack {
private:
    int* stack;
    int begin;
    int end;
public:
    Stack(int N) {
        stack = new int[N];
        begin = N / 2;
        end = N / 2 - 1;
    }

    void push(int num);
    void pop();
    void size();
    bool empty();
    void top();

    ~Stack() {
        delete[] stack;
    }
};

void Stack::push(int num) {
    stack[++end] = num;
}

void Stack::pop() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << stack[end--] << '\n';
    }
}

void Stack::size() {
    if (empty()) {
        cout << 0 << '\n';
    }
    else {
        cout << end - begin + 1 << '\n';
    }
}

bool Stack::empty() {
    if (begin > end) {
        return true;
    }
    else {
        return false;
    }
}

void Stack::top() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << stack[end] << '\n';
    }
}

//10828-스택-Silver4-https://www.acmicpc.net/problem/10828

int main() {
    fastIo;

    int N;
    cin >> N;
    Stack stack(2 * N);

    for (int i = 0; i < N; ++i) {
        string cmd;
        cin >> cmd;

        if (cmd == "push") {
            int num;
            cin >> num;

            stack.push(num);
        }

        else if (cmd == "pop") {
            stack.pop();
        }

        else if (cmd == "size") {
            stack.size();
        }

        else if (cmd == "empty") {
            cout << stack.empty() << '\n';
        }

        else if (cmd == "top") {
            stack.top();
        }
    }
}