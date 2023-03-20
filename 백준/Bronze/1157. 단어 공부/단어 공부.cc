#include <iostream>
#include <cstring>
using namespace std;

int main() {
    char input[1000001];

    scanf("%s", input);

    int length = strlen(input);

    //소문자로 바꾼다.
    for (int i = 0; i < length; i++) {
        if (input[i] >= 'A' && input[i] <= 'Z') {
            input[i] = input[i] + 32;
        }
    }

    //알파벳 개수를 센다.
    int alphabet[26] = { 0, };

    for (int i = 0; i < length; i++) {
        alphabet[input[i] - 'a']++;
    }

    //가장 많이 나온 알파벳을 찾는다.
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < 26; i++) {
        if (alphabet[i] > max) {
            max = alphabet[i];
            maxIndex = i;
        }
    }

    //가장 많이 나온 알파벳이 여러개인지 확인한다.
    bool isMultiple = false;

    for (int i = 0; i < 26; i++) {
        if (i == maxIndex) {
            continue;
        }

        if (alphabet[i] == max) {
            isMultiple = true;
            break;
        }
    }

    if (isMultiple) {
        printf("?");
    }
    else {
        printf("%c", maxIndex + 'A');
    }

    return 0;
}