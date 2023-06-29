T = int(input())

for i in range(0, 3):
    data = input().split()
    b = list(map(int, data))

    b.sort()

    print("#" + str(i + 1), b[9])