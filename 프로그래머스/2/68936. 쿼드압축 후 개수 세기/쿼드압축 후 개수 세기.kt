class Solution {
    private var totalZeros = 0
    private var totalOnes = 0
    
    fun solution(arr: Array<IntArray>): IntArray {
        for (i in 0..arr.size - 1) {
            for (j in 0..arr.size - 1) {
                if (arr[i][j] == 1) {
                    totalOnes += 1
                }
                else if (arr[i][j] == 0) {
                    totalZeros += 1
                }
            }
        }
        
        compress(0, 0, arr.size, arr)
        
        return intArrayOf(totalZeros, totalOnes)
    }
    
    fun compress(y: Int, x: Int, size: Int, arr: Array<IntArray>) {
        var zeros = 0
        var ones = 0
        
        // check if all elements are the same
        for (i in y..y + size - 1) {
            for (j in x..x + size - 1) {
                if (arr[i][j] == 1) {
                    ones += 1
                }
                else {
                    zeros += 1
                }
            }
        }
        
        // when elements are all same
        if (zeros == 0) {
            for (i in y..y + size - 1) {
                for (j in x..x + size - 1) {
                    arr[i][j] = 1
                }
            }
            totalOnes -= size * size - 1
        }
        else if (ones == 0) {
            for (i in y..y + size - 1) {
                for (j in x..x + size - 1) {
                    arr[i][j] = 0
                }
            }
            totalZeros -= size * size - 1
        }
        else if (size /2 > 1) {
            val half = size / 2
            compress(y, x, half, arr)
            compress(y, x + half, half, arr)
            compress(y + half, x, half, arr)
            compress(y + half, x + half, half, arr)
        }
    }
}