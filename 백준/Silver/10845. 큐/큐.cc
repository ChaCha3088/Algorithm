#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)
#define TRUE 1
#define FALSE 0

using namespace std;

class Queue {
private:
    int* queue;
    int begin;
    int end;
public:
    Queue(int N) {
        queue = new int[N];
        begin = N / 2;
        end = N / 2 - 1;
    }

    void push(int num);
    void pop();
    void size();
    bool empty();
    void front();
    void back();

    ~Queue() {
        delete[] queue;
    }
};

void Queue::push(int num) {
    queue[++end] = num;
}

void Queue::pop() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << queue[begin++] << '\n';
    }
}

void Queue::size() {
    if (empty()) {
        cout << 0 << '\n';
    }
    else {
        cout << end - begin + 1 << '\n';
    }
}

bool Queue::empty() {
    if (begin > end) {
        return true;
    }
    else {
        return false;
    }
}

void Queue::front() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << queue[begin] << '\n';
    }
}

void Queue::back() {
    if (empty()) {
        cout << -1 << '\n';
    }
    else {
        cout << queue[end] << '\n';
    }
}

//10845-큐-Silver4-https://www.acmicpc.net/problem/10845

int main() {
    fastIo;

    int N;
    cin >> N;
    Queue queue(2 * N);

    for (int i = 0; i < N; ++i) {
        string cmd;
        cin >> cmd;

        if (cmd == "push") {
            int num;
            cin >> num;

            queue.push(num);
        }

        else if (cmd == "pop") {
            queue.pop();
        }

        else if (cmd == "size") {
            queue.size();
        }

        else if (cmd == "empty") {
            cout << queue.empty() << '\n';
        }

        else if (cmd == "front") {
            queue.front();
        }

        else if (cmd == "back") {
            queue.back();
        }
    }
}