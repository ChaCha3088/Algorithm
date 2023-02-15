import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        
        //1번 수포자 정답지 생성
        int[] firstOne = new int[answers.length];
        
        int[] firstMethod = {1, 2, 3, 4, 5};
        
        for (int i = 0; i < answers.length; i++) {
            firstOne[i] = firstMethod[i % 5];
        }
        
        //2번 수포자 정답지 생성
        int[] secondOne = new int[answers.length];
        
        int[] secondMethod = {1, 3, 4, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                secondOne[i] = 2;
            } else if (i % 2 == 1) {
                secondOne[i] = secondMethod[(i / 2) % 4];
            }
        }
        
        //3번 수포자 정답지 생성
        int[] thirdOne = new int[answers.length];
        
        int[] thirdMethod = {3, 1, 2, 4, 5};
        
        for (int i = 0; i < answers.length; i++) {
            thirdOne[i] = thirdMethod[(i / 2) % 5];
        }
        
        System.out.println(Arrays.toString(firstOne));
        System.out.println(Arrays.toString(secondOne));
        System.out.println(Arrays.toString(thirdOne));

        
        Map<Integer, Integer> lhm = new LinkedHashMap<>();
        
        lhm.put(1, score(firstOne, answers));
        lhm.put(2, score(secondOne, answers));
        lhm.put(3, score(thirdOne, answers));
        
        Map<Integer, Integer> result = sortMapByValue(lhm);
        
        List<Integer> list = result.entrySet().stream()
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
            
        List<Integer> values = result.values()
            .stream()
            .collect(Collectors.toList());
                
        //max값 찾기
        int max = values.isEmpty() ? -1 : Collections.max(values);
        
        //max값과 같은 값을 가지면 answerList에 넣기
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            if (result.get(list.get(i)) == max) {
                answerList.add(list.get(i));
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private int score(int[] input, int[] answers) {
        int result = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (input[i] == answers[i]) {
                result += 1;
            }
        }
        
        return result;
    }
    
    private LinkedHashMap<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        
        return result;
    }
}