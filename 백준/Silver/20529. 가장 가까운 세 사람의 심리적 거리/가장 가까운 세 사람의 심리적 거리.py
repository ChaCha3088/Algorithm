from itertools import combinations

T = int(input())

for i in range(0, T):
    N = int(input())

    arr = input().split()
    
    if (N >= 33):
        print(0)
        continue

    idxs = list(range(0, N))
    combi = list(combinations(idxs, 3))

    min = 10000

    for j in combi:
        sum = 0

        x = arr[j[0]]
        y = arr[j[1]]
        distance = 0

        for k in range(0, 4):
            if (x[k] != y[k]):
                distance += 1

        sum += distance

        x = arr[j[1]]
        y = arr[j[2]]
        distance = 0

        for k in range(0, 4):
            if (x[k] != y[k]):
                distance += 1

        sum += distance

        x = arr[j[0]]
        y = arr[j[2]]
        distance = 0

        for k in range(0, 4):
            if (x[k] != y[k]):
                distance += 1

        sum += distance

        if (sum < min):
            min = sum

    print(min)      