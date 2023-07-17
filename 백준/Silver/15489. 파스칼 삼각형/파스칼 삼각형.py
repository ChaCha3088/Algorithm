R, C, W = map(int, input().split())

# 초기화
arr = []
arr.append([0])
arr.append([0, 1])
for i in range(2, R + W + 1):
    temp = [0]

    for j in range(1, i + 1):
        if j == 1:
            temp.append(1)
        elif j == i:
            temp.append(1)
        else:
            temp.append(0)

    arr.append(temp)

# 계산
depth = 1
for i in range(3, R + W + 1):
    for j in range(2, 2 + depth):
        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]
    depth += 1

# 합
sum = 0

depth = 1
for i in range(R, R + W):
    for j in range(C, C + depth):
        sum += arr[i][j]
    depth += 1

# 출력
print(sum)