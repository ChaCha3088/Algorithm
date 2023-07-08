def howManyBallons(time):
    global Ai
    sum = 0

    for i in Ai:
        sum += time // i

    return sum

data = input().split()
N = int(data[0])
M = int(data[1])

Ai = []

data = input().split()
for i in data:
    Ai.append(int(i))

sortedAi = sorted(Ai)
minValue = sortedAi[0]

maxTime = M * minValue + 1

l = 0
r = maxTime

while l < r:
    mid = (l + r) // 2

    if M <= howManyBallons(mid):
        r = mid
    else:
        l = mid + 1

print(l)