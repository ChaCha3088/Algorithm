N = int(input())

A = []
data = input().split()

for j in data:
    A.append(int(j))

op = []
data = input().split()
for j in range(4):
    op.append(int(data[j]))

maximum = -1e9
minimum = 1e9


def dfs(depth, total, plus, minus, multiply, divide):
    global maximum, minimum
    if depth == N:
        maximum = max(total, maximum)
        minimum = min(total, minimum)
        return

    if plus:
        dfs(depth + 1, total + A[depth], plus - 1, minus, multiply, divide)
    if minus:
        dfs(depth + 1, total - A[depth], plus, minus - 1, multiply, divide)
    if multiply:
        dfs(depth + 1, total * A[depth], plus, minus, multiply - 1, divide)
    if divide:
        dfs(depth + 1, int(total / A[depth]), plus, minus, multiply, divide - 1)


dfs(1, A[0], op[0], op[1], op[2], op[3])

print(maximum)
print(minimum)
