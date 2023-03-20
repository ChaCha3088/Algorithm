//연산자의 기호는 ＠으로, A＠B = (A+B)×(A-B)으로 정의내리기로 했다.
//정수 A, B가 주어지면 A＠B를 계산하는 프로그램을 만들어주자!

//첫째 줄에 A, B가 주어진다. (1 ≤ A, B ≤ 100,000)

//첫째 줄에 A＠B의 결과를 출력한다.

#include <iostream>
using namespace std;

int main() {
    int A, B;
    scanf("%d %d", &A, &B);

    printf("%d", (A+B)*(A-B));

    return 0;
}