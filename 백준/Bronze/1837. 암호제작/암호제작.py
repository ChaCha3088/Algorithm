import math

data = input().split()

P = int(data[0])
k = int(data[1])

#k - 1 부터 아래로 나눠보면서 찾자
#없으면 ok

prime = []
max = k
for i in range(0, max + 1):
    prime.append(True)
prime[0] = False
prime[1] = False

target = 2

answer = 0

while (target < max):
    idx = 2
    where = target * idx
    while (where < max):
        prime[where] = False
        idx += 1
        where = target * idx
    target += 1
    while (target < max and prime[target] == False):
        target += 1

end = min(math.floor(math.sqrt(P)), max - 1)

while (end >= 2):
    if (prime[end] == False):
        end -= 1
    else:
        if (P % end == 0):
            another = P // end
            answer = min(another, end)
            break
        else:
            end -= 1

if (answer == 0):
    print("GOOD")
else:
    print("BAD", answer)