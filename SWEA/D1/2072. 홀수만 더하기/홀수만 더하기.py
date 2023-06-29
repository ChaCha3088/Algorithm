T = int(input())

for i in range(0, T):
    data = input().split()
    b = list(map(int, data))

    sum = 0

    for j in range(0, len(b)):
        if (b[j] % 2 == 1):
            sum += b[j]

    print("#" + str(i + 1), sum)
