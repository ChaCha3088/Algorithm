map = [[0 for j in range(101)] for i in range(101)]
arr = []

for i in range(0, 4):
    arr.append(input().split(" "))

for a in arr:
    x = int(a[0])
    y = int(a[1])
    x_diff = int(a[2]) - int(a[0])
    y_diff = int(a[3]) - int(a[1])

    for j in range(0, x_diff):
        for k in range(0, y_diff):
            map[x + j][y + k] = 1

sum = 0

for i in range(1, 101):
    for j in range(1, 101):
        if map[i][j] == 1:
            sum += 1

print(sum)