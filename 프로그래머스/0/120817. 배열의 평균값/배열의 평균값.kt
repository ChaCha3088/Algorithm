class Solution {
    fun solution(numbers: IntArray): Double {
        val sum = numbers.sum()
        
        return sum.toDouble() / numbers.size
    }
}