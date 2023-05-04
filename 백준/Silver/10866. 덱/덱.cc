#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

class Deque {
private:
    int* deque;
    int begin;
    int end;
public:
    Deque(int N) {
        deque = new int[N];
        begin = N / 2;
        end = N / 2 - 1;
    }

    void push_front(int num);
    void push_back(int num);
    void pop_front();
    void pop_back();
    void size();
    bool empty();
    void front();
    void back();

    ~Deque() {
        delete[] deque;
    }
};

void Deque::push_front(int num) {
    deque[--begin] = num;
}

void Deque::push_back(int num) {
    deque[++end] = num;
}

void Deque::pop_front() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << deque[begin++] << '\n';
//        deque[begin] = NULL;
    }
}

void Deque::pop_back() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << deque[end--] << '\n';
//        deque[end] = NULL;
    }
}

void Deque::size() {
    if (empty()) {
        cout << 0 << '\n';
    }
    else {
        cout << end - begin + 1 << '\n';
    }
}

bool Deque::empty() {
    if (begin > end) {
        return true;
    }
    else {
        return false;
    }
}

void Deque::front() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << deque[begin] << '\n';
    }
}

void Deque::back() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << deque[end] << '\n';
    }
}

int main() {
    fastIo;
    
    int N;
    cin >> N;
    Deque deque(2 * N);

    for (int i = 0; i < N; i++) {
        string cmd;
        cin >> cmd;

        if (cmd == "push_front") {
            int num;
            cin >> num;

            deque.push_front(num);
        }

        else if (cmd == "push_back") {
            int num;
            cin >> num;

            deque.push_back(num);
        }

        else if (cmd == "pop_front") {
            deque.pop_front();
        }

        else if (cmd == "pop_back") {
            deque.pop_back();
        }

        else if (cmd == "size") {
            deque.size();
        }

        else if (cmd == "empty") {
            cout << deque.empty() << '\n';
        }

        else if (cmd == "front") {
            deque.front();
        }

        else if (cmd == "back") {
            deque.back();
        }
    }
}