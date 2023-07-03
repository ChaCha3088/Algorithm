status = 0

for i in range(0, 10):
    instruction = int(input())
    if (instruction == 1):
        status += 1
        status %= 4
    elif (instruction == 2):
        status += 2
        status %= 4
    elif (instruction == 3):
        status += 3
        status %= 4

if (status == 0):
    print("N")
elif (status == 1):
    print("E")
elif (status == 2):
    print("S")
elif (status == 3):
    print("W")