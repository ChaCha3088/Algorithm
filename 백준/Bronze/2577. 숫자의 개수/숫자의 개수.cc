#include <iostream>
#include <sstream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a;
    cin >> b;
    cin >> c;

    int result = a * b * c;

    stringstream ss;
    ss << result;

    string str = ss.str();

    int arr[10] = {0, };

    for (int i = 0; i < str.length(); i++) {
        arr[str[i] - '0']++;
    }

    for (int i = 0; i < 10; i++) {
        cout << arr[i] << endl;
    }

    return 0;
}