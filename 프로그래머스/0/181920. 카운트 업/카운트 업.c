// 정수 start_num와 end_num가 주어질 때, 
// start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int start_num, int end_num) {
    // 메모리 할당
    int* answer = (int*) malloc(sizeof(int) * (end_num - start_num + 1));

    for (int i = start_num; i <= end_num; i++) {
        answer[i - start_num] = i;
    }

    return answer;
}