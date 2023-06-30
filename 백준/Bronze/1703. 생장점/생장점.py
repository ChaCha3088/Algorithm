iter = True

while (iter):
    data = input().split()
    a = int(data[0])

    if (a == 0):
        iter = False
        continue

    tree = [1]

    for i in range(0, a):
        level = i + 1
        sFactor = int(data[2 * i + 1])
        removed = int(data[2 * i + 2])

        tree.append(sFactor * tree[i] - removed)

    print(tree[a])