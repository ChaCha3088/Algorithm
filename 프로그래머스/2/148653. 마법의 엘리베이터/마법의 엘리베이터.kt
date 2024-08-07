class Solution {
    fun solution(storey: Int): Int {
        var answer = 0
        
        var story = storey
        var div = 10
        var stage = 1
        
        while (story > 0) {
            val left = story % div

            val amount = left / stage

            when (amount) {
                in 1..4 -> {
                    story -= left

                    answer += amount
                }
                in 6..9 -> {
                    story += (div - left)

                    answer += (10 - amount)
                }
                5 -> {
                    val tmp = story / div % 10
                    if (tmp >= 5) {
                        answer += (10 - left)
                        story += left
                    } else {
                        answer += amount
                        story -= left
                    }
                }
            }

            div *= 10
            stage *= 10
        }   
        
        return answer
    }
}