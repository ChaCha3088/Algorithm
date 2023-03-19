//어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
//A+: 4.3, A0: 4.0, A-: 3.7
//B+: 3.3, B0: 3.0, B-: 2.7
//C+: 2.3, C0: 2.0, C-: 1.7
//D+: 1.3, D0: 1.0, D-: 0.7
//F: 0.0

//첫째 줄에 C언어 성적이 주어진다. 성적은 문제에서 설명한 13가지 중 하나이다.

//첫째 줄에 C언어 평점을 출력한다.

#include <iostream>
using namespace std;

int main() {
    char str[3];

    scanf("%s", str);

    if (str[0] == 'A') {
        if (str[1] == '+') {
            printf("4.3");
        }
        else if (str[1] == '0') {
            printf("4.0");
        }
        else if (str[1] == '-') {
            printf("3.7");
        }
    }
    else if (str[0] == 'B') {
        if (str[1] == '+') {
            printf("3.3");
        }
        else if (str[1] == '0') {
            printf("3.0");
        }
        else if (str[1] == '-') {
            printf("2.7");
        }
    }
    else if (str[0] == 'C') {
        if (str[1] == '+') {
            printf("2.3");
        }
        else if (str[1] == '0') {
            printf("2.0");
        }
        else if (str[1] == '-') {
            printf("1.7");
        }
    }
    else if (str[0] == 'D') {
        if (str[1] == '+') {
            printf("1.3");
        }
        else if (str[1] == '0') {
            printf("1.0");
        }
        else if (str[1] == '-') {
            printf("0.7");
        }
    }
    else if (str[0] == 'F') {
        printf("0.0");
    }

    return 0;
}