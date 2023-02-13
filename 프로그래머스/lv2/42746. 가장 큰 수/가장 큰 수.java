import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        //list 만들기
        List<String> stringNumbers = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            stringNumbers.add(Integer.toString(numbers[i]));
        }
        
        //sort하는 함수를 배워보자
        //comparator 써서
        Collections.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if (stringNumbers.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringNumbers.size(); i++) {
            stringBuilder.append(stringNumbers.get(i));
        }

        return stringBuilder.toString();
    }
}