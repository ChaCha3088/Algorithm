#include <iostream>
#include <string>
#include <algorithm>
#include <map>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N;
int r = 2;
int aArray[1001] = {0, };
//int result[10000000][2] = {0};
int where = 0;

void combination() {
    int temp[100000] = {0, };
    for (int i = 0; i < N - r; ++i) {
        temp[i] = 0;
    }

    for (int i = N - r; i < N; ++i) {
        temp[i] = 1;
    }

    do {
        int put = 0;
        for (int i = 0; i < N; ++i) {
            if (temp[i] == 1) {
                //result[where][put] = aArray[i];
                ++put;
            }
        }
        ++where;
    } while (next_permutation(temp, temp + N));

}

int main() {
    fastIo;

    //입력
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int tmp;
        cin >> tmp;
        ++aArray[tmp];
    }

    //최대값 찾기
    int max = 0;
    
    for (int i = 1; i < 1001; ++i) {
        if (aArray[i] > 0) {
            --aArray[i];
            for (int j = i; j < 1001; ++j) {
                if (aArray[j] > 0) {
                    --aArray[j];
                    int product = i * j;
                    int sum = 0;
                    while (product > 0) {
                        int temp = product % 10;
                        sum += temp;
                        product /= 10;

                        if (sum > max) {
                            max = sum;
                        }
                    }
                    ++aArray[j];
                }
            }
            ++aArray[i];
        }
    }

    cout << max << "\n";
}