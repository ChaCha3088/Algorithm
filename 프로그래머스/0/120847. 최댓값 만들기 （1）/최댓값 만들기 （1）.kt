class Solution {
    fun solution(numbers: IntArray): Int {
        val sor = numbers.sorted()
        
        return sor[sor.size - 1] * sor[sor.size - 2]
    }
}