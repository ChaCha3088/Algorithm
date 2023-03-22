#include <iostream>
#include <sstream>
#include <string.h>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;

    stringstream aa;
    aa << A;

    stringstream bb;
    bb << B;

    string a = aa.str();
    string b = bb.str();

    char aaa[101];
    strcpy(aaa, a.c_str());

    char bbb[101];
    strcpy(bbb, b.c_str());

    int lenA = strlen(aaa);
    int lenB = strlen(bbb);

    char resultA[101];
    char resultB[101];

    for (int i = 0; i < lenA; i++) {
        resultA[i] = aaa[lenA - i - 1];
        resultB[i] = bbb[lenB - i - 1];
    }

    int resultAInt = atoi(resultA);
    int resultBInt = atoi(resultB);

    if (resultAInt > resultBInt) {
        cout << resultAInt << endl;
    } else {
        cout << resultBInt << endl;
    }

    return 0;
}