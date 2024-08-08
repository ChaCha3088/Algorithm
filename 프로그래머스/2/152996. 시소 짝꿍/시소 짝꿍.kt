class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val weight = weights.sorted().toIntArray()
        
        for (i in weight.indices) {
            for (j in i + 1 until weight.size) {
                if (weight[i] == weight[j]) {
                    answer++
                    continue
                }
                if (weight[i] * 2 == weight[j]) {
                    answer++
                    continue
                }
                if (weight[i] * 3 == weight[j] * 2) {
                    answer++
                    continue
                }
                if (weight[i] * 4 == weight[j] * 3) {
                    answer++
                    continue
                }
            }
        }
        return answer
    }
}