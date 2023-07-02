N = int(input())
A = []
sum = 0

data = input().split()
for i in range(0, N):
    A.append(int(data[i]))

data = input().split()

B = int(data[0])
C = int(data[1])

for a in A:
    sum += 1
    left = a - B
    if (left > 0):
        sum += left // C
        if (left % C > 0):
            sum += 1

print(sum)