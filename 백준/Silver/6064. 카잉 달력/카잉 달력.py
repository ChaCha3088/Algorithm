T = int(input())

for i in range(T):
    data = input().split()
    M = int(data[0])
    N = int(data[1])
    x = int(data[2])
    y = int(data[3])

    x -= 1
    y -= 1

    isFound = False
    for i in range(x, N * M, M):
        if i % N == y:
            print(i + 1)
            isFound = True
            break

    if not isFound:
        print(-1)