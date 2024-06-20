class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer = num_list.toCollection(ArrayList())
        
        val last = num_list[num_list.size - 1]
        val lastBefore = num_list[num_list.size - 2]
        
        if (last > lastBefore) {
            answer.add(last - lastBefore)
        }
        else {
            answer.add(last * 2)
        }
        
        return answer.toIntArray()
    }
}