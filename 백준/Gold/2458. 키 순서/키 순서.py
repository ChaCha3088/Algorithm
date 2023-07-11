# 자신이 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지를 출력

def dfs(i, idx):
    global comparison

    for j in comparison[idx]:
        if not check[i][j]:
            check[i][j] = 1
            check[j][i] = 1
            dfs(i, j)


data = input().split()
N = int(data[0])
M = int(data[1])

answer = 0

check = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

global comparison
comparison = [[] for i in range(N + 1)]

for i in range(M):
    data = input().split()
    if int(data[1]) not in comparison[int(data[0])]:
        comparison[int(data[0])].append(int(data[1]))

# 1번 학생부터 확인
for i in range(1, N + 1):
    check[i][i] = 1
    dfs(i, i)

for row in check:
    if row == [0] + [1] * N:
        answer += 1

print(answer)