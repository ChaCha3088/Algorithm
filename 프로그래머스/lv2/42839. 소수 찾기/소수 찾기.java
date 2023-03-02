import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    String[] splitted;
    int answer = 0;
    
    public int solution(String numbers) {
        
        splitted = numbers.split("");
        int count = splitted.length;
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            list.add(splitted[i]);
        }
        
        //소수 만들기
        for (int length = 1; length <= count; length++) {
            makeNumber(list, "", length);
        }
        
        List<Integer> setList = new ArrayList<>(set);
        System.out.println(setList);
        
        //소수 검증
        for (int i : setList) {
            if (i >= 2) {
                if (sosu(i)) {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    private boolean sosu(int input) {
        
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void makeNumber(List<String> cards, String input, int length) {
        String result = input;
        
        if (result.length() == length) {
            set.add(Integer.parseInt(result));
            return;
        }
        
        List<String> arr = new ArrayList<>();
        for (String str : cards) {
            arr.add(str);
        }
        
        if (result.length() < length) {
            for (int i = 0; i < arr.size(); i++) {
                String number = arr.get(i);
                String temp = result;
                temp += number;
                arr.remove(i);
                makeNumber(arr, temp, length);
                arr.add(i, number);
            }
        }
        
    }
}