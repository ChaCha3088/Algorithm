data = input().split()
N = int(data[0])
M = int(data[1])

A = []
data = input().split()

remainder = [0 for _ in range(M)]
remainder[0] = 1

sumOfNumbers = 0
for i in data:
    sumOfNumbers += int(i)
    sumOfNumbers = sumOfNumbers % M
    remainder[sumOfNumbers] += 1

count = 0

for i in remainder:
    count += ((i * (i - 1)) / 2)

print(int(count))
