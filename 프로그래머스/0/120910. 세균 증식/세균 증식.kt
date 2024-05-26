import kotlin.math.pow

class Solution {
    fun solution(n: Int, t: Int): Int {
        var number = n
        
        for (i in 1..t)
            number *= 2
        
        return number
    }
}