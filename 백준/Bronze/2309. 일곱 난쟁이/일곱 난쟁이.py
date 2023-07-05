#일곱 난쟁이의 키의 합이 100

arr = []

sum = 0

#아홉 개의 줄에 걸쳐 난쟁이들의 키
for i in range(9):
    inp = int(input())
    arr.append(inp)
    sum += inp

#두개 골라서 빼고 확인
for i in range(9):
    j = i + 1
    iter = True
    while (iter and j < 9):
        cal = arr[i] + arr[j]
        sum -= cal
        if (sum == 100):
            one = arr[i]
            two = arr[j]
            arr.remove(one)
            arr.remove(two)
            iter = False
            break
        sum += cal
        j += 1
    if (iter == False):
        break

#일곱 난쟁이의 키를 오름차순으로 출력
arr = sorted(arr)

for i in arr:
    print(i)