// 정수 리스트 num_list가 주어질 때, 
// 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 
// 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int* solution(int num_list[], size_t num_list_len) {
    int* answer = (int*)malloc(sizeof(int) * num_list_len + 1);

    // 배열 복사
    for (int i = 0; i < num_list_len; i++) {
        answer[i] = num_list[i];
    }

    if (num_list[num_list_len - 1] > num_list[num_list_len - 2]) {
        answer[num_list_len] = num_list[num_list_len - 1] - num_list[num_list_len - 2];
    }
    else {
        answer[num_list_len] = num_list[num_list_len - 1] * 2;
    }

    return answer;
}