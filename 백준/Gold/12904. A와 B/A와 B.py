# 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임
# 문자열의 뒤에 A를 추가한다.
# 문자열을 뒤집고 뒤에 B를 추가한다.

S = input().rstrip("\n")
T = input()

while True:
    if len(T) == len(S):
        break

    if T[len(T) - 1] == "A":
        T = T[:-1]
    else:
        T = T[:-1]
        T = "".join(reversed(T))

if S == T:
    print(1)
else:
    print(0)