inp = []

N = int(input())

for i in range(N):
    data = input().split()
    data = list(map(int, data))
    inp.append(data)

arr = [[0 for j in range(1000)] for i in range(1000)]

result = []

before = 0

idx = N - 1
while (idx >= 0):
    plus = 0

    x = inp[idx][0]
    y = inp[idx][1]
    dx = inp[idx][2]
    dy = inp[idx][3]

    for j in range(x, x + dx):
        for k in range(y, y + dy):
            if (arr[j][k] == 0):
                arr[j][k] = 1
                plus += 1

    result.append(plus)

    before = plus

    idx -= 1

index = N - 1
while (index >= 0):
    print(result[index])
    index -= 1