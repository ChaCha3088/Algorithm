# 접두사란 S의 가장 앞에서부터 부분 문자열
# 총 N개의 문자열로 이루어진 집합 S

# 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 문자열 중 적어도 하나의 접두사인 것의 개수를 구하는 프로그램

# 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다.
# 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

# M개의 문자열 중에 총 몇 개가 포함되어 있는 문자열 중 적어도 하나의 접두사인지 출력

N, M = map(int, input().split())

answer = 0

SList = []
for i in range(N):
    SList.append(input())

SList = sorted(SList)

ins = []
for i in range(M):
    ins.append(input())

for target in ins:

    l = 0
    r = len(SList)
    before = 0

    while l < r:
        mid = (l + r) // 2

        if before == mid:
            break

        before = mid

        comp = SList[mid][:len(target)]

        if comp == target:
            answer += 1
            break

        elif SList[mid][:len(target)] > target:
            r = mid

        elif SList[mid][:len(target)] < target:
            l = mid + 1

print(answer)