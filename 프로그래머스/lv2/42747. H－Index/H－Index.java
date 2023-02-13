import java.util.*;
import java.util.stream.*;

class Solution {
    private List<Integer> sortedCitations;
    private int n = 0;
    
    public int solution(int[] citations) {
        
        int answer = 0;
        
        n = citations.length;
        
        //Array to List
        List<Integer> citationList = Arrays.stream(citations)
                        .boxed()
                        .collect(Collectors.toList());
        
        //정렬
        this.sortedCitations = citationList.stream()
		    .sorted()
            .collect(Collectors.toList());
        
        System.out.println(sortedCitations);
        
        for (int i = 0; i < sortedCitations.size(); i++) {
            int m = count(sortedCitations.get(i));
            if (sortedCitations.get(i) >= m) {
                return m;
            }
        }
        
        return answer;
    }
    
//     private int calculate(int firstIndex, int lastIndex) {
//         int answer = -1;
        
//         //중앙값을 h로 시작
//         int hIndex = medium(firstIndex, lastIndex);
//         int h = sortedCitations.get(hIndex);
        
//         //h번 이상 인용된 논문
//         int m = count(sortedCitations, h, firstIndex, lastIndex);
            
//         //나머지 논문
//         int r = n - m;
        
//         if (m == h) {
//             return h;
//         }
        
//         //r >= h
//         //h가 작다는 뜻이므로
//         //h의 인덱스의 오른쪽 중앙값
//         if (r >= h) {
//             answer = calculate(hIndex + 1, lastIndex);
//         }
        
//         //h >= m
//         //h가 크다는 뜻이므로
//         //h의 인덱스의 왼쪽 중앙값
//         if (h >= m) {
//             answer = calculate(firstIndex, hIndex - 1);
//         }
        
//         return answer;
//     }
    
    //h번 이상 인용된 논문
    private int count(int h) {
        int count = 0;
        
        for (int i = 0; i < sortedCitations.size(); i++) {
            if (sortedCitations.get(i) >= h) {
                count += 1;
            }
        }
        
        return count;
    }
    
//     //중앙값의 index를 구해주는 메소드
//     private int medium(int firstIndex, int lastIndex) {
//         int result = -1;
//         int sub = lastIndex - firstIndex;
        
//         if (sub % 2 == 0) {
//             result = firstIndex + sub / 2;
//         } else if (sub % 2 == 1) {
//             result = firstIndex + (sub / 2) + 1;
//         }
        
//         return result;
//     }
}