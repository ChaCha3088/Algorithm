private var answer = mutableSetOf<Int>()

private var input = IntArray(101)

// 방문 배열
private var visited = BooleanArray(101)

private var isAnswer = false

private var stringBuffer = StringBuffer()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    // 입력
    val N = readLine().toInt()

    for (i in 1..N) {
        val number = readLine().toInt()
        input[i] = number
    }

    for (i in 1..N) {
        visited[i] = true
        dfs(i, input[i])
        visited.fill(false)
        isAnswer = false
    }

    // 출력
    stringBuffer.append(answer.size).append("\n")
    answer.toList().sorted().forEach() {
        stringBuffer.append(it).append("\n")
    }

    print(stringBuffer.toString())
}

private fun dfs(start: Int, number: Int) {
    // 방문 확인
    if (visited[number]) {
        if (start == number) {
            isAnswer = true
            answer.add(number)
        }
        return
    }

    // 방문 처리
    visited[number] = true

    // 다음 방문
    dfs(start, input[number])

    if (isAnswer) {
        answer.add(number)
        answer.add(input[number])
    }
}