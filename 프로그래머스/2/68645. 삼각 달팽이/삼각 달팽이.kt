class Solution {
    private val dx = intArrayOf(0, 1, -1)
    private val dy = intArrayOf(1, 0, -1)
    private var arr = Array(1) { IntArray(1) }
    
    fun solution(n: Int): IntArray {
        // 배열 초기화
        arr = Array(n) { IntArray(n) }

        // max값
        val max = (n + 1) * n / 2

        // 시작값
        var number = 1

        // index
        var index = 0

        var x = 0
        var y = 0

        arr[0][0] = number

        while (number < max) {
            // 다음 갈 곳
            val nx = x + dx[index]
            val ny = y + dy[index]

            // 범위 체크
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[ny][nx] != 0) {
                index = (index + 1) % 3
                continue
            }

            // 값 넣기
            arr[ny][nx] = ++number

            // 통과 했다면
            x = nx
            y = ny
        }

        // max개의 배열 만들기
        var answer = IntArray(max)
        var idx = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][j] == 0) {
                    break
                }

                answer[idx++] = arr[i][j]
            }
        }
        
        return answer
    }
}