class Solution {
    fun solution(numbers: IntArray, num1: Int, num2: Int): IntArray {
        return numbers.sliceArray(num1..num2)
    }
}