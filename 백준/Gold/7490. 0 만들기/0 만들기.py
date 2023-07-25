def select_operator(now, old_string):
    global N
    if now == N + 1:
        calc(old_string)
        return

    select_operator(now + 1, old_string + ' ' + str(now))
    select_operator(now + 1, old_string + '+' + str(now))
    select_operator(now + 1, old_string + '-' + str(now))


def calc(text):
    global answer
    temp = text.replace(' ', '')
    if eval(temp) == 0:
        answer.append(text)


T = int(input())


for i in range(T):
    N = int(input())
    arr = [i for i in range(N + 1)]
    answer = []

    select_operator(2, '1')

    for ans in answer:
        print(ans)

    print()