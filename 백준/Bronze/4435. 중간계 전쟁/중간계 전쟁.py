간달프 = {0: 1, 1: 2, 2: 3, 3: 3, 4: 4, 5: 10}
사우론 = {0: 1, 1: 2, 2: 2, 3: 2, 4: 3, 5: 5, 6: 10}
message = {0: "No victor on this battle field", 1: "Good triumphs over Evil", 2: "Evil eradicates all trace of Good"}

T = int(input())

for i in range(0, T):
    result = 0

    data = input().split(" ")
    간달프_sum = 0
    간달프_입력 = list(map(int, data))
    for j in range(len(간달프_입력)):
        간달프_sum += 간달프.get(j) * 간달프_입력[j]

    data = input().split(" ")
    사우론_sum = 0
    사우론_입력 = list(map(int, data))
    for j in range(len(사우론_입력)):
        사우론_sum += 사우론.get(j) * 사우론_입력[j]

    if (간달프_sum > 사우론_sum):
        result = 1
    elif (사우론_sum > 간달프_sum):
        result = 2
    else:
        result = 0

    print("Battle", str(i + 1) + ": " + message.get(result))