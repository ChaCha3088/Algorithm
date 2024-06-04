import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = -1
        
        var sum1 = 0L
        var sum2 = 0L
        
        val q1: Queue<Long> = LinkedList()
        val q2: Queue<Long> = LinkedList()
        
        // Putting in queues
        queue1.map {
            val i = it.toLong()
            q1.offer(i)
            sum1 += i
        }
        
        queue2.map {
            val i = it.toLong()
            q2.offer(i)
            sum2 += i
        }
        
        var count = 1
        val si = queue1.size * 3
        
        while (count <= si) {
            if (q1.isEmpty() || q2.isEmpty()) {
                return -1
            }
            
            if (sum1 > sum2) {
                val m = q1.poll()
                q2.offer(m)
                sum1 -= m
                sum2 += m
            }
            else if (sum1 < sum2) {
                val m = q2.poll()
                q1.offer(m)
                sum1 += m
                sum2 -= m
            }
            else {
                return count - 1
            }
            
            count += 1
        }
        
        return answer
    }
}