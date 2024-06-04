import java.util.Stack

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var kk = k

        val stack = Stack<Int>()
        
        number.toCharArray().map {
            val n = it.digitToInt()

            // 새로운 숫자가 peek보다 클 때
            while (kk > 0 && !stack.empty() && n > stack.peek()) {
                // 오빠 빼
                stack.pop()
                kk -= 1
            }

            stack.push(n)
        }
        
        while (!stack.empty())
            answer += stack.pop().toString()
        
        return if (kk > 0) answer.reversed().substring(0, answer.length - kk) else answer.reversed()
    }
}