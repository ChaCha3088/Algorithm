import java.util.Collections;

class Solution {
    private int h = 0;
    
    public int solution(int[] citations) {
        h = citations.length;
        
        while (h >= 0) {
            int eSang = 0;
            
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) {
                    eSang += 1;
                }
            }
            
            int rest = citations.length - eSang;
            
            if (eSang >= h && rest <= h) {
                return h;
            }
            
            h -= 1;
        }
        
        return 0;
    }
}