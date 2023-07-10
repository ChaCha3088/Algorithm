# 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램
# 최소 - 최대

arr = input().split('-')
sum = 0

# -가 나타나기 전까지 더하기
for i in arr[0].split('+'):
    sum += int(i)

# - 이후 빼기
for i in arr[1:]:
    for j in i.split('+'):
        sum -= int(j)

print(sum)
