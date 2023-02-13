import java.util.*;

class Solution {
    int answer = 9999;
    String[] wordList;
    String start;
    String end;
    
    public int solution(String begin, String target, String[] words) {
        wordList = words;
        start = begin;
        end = target;
        
        boolean[] visited = new boolean[words.length];
        convert(begin, 0, visited);
        
        if (answer == 9999) {
            answer = 0;
        }
        
        return answer;
    }
    
    private void convert(String input, int count, boolean[] visited) {
        
        boolean[] history = Arrays.copyOf(visited, visited.length);
        
        for (int i = 0; i < start.length(); i++) {
            List<Integer> changeableWordsIndex = findChangeableWordsIndex(input, i);
            
            if (changeableWordsIndex.size() > 0) {
                for (int j = 0; j < changeableWordsIndex.size() ; j++) {
                    String changeableWord = wordList[changeableWordsIndex.get(j)];
                    
                    if (changeableWord.equals(end)) {
                        answer = Math.min(answer, count + 1);
                    } else if (!changeableWord.equals(start) & !history[changeableWordsIndex.get(j)]) {
                        history[changeableWordsIndex.get(j)] = true;
                        convert(changeableWord, count + 1, history);
                    }
                }
            }
        }
    }
    
    private List<Integer> findChangeableWordsIndex(String input, int index) {
        List<Integer> result = new ArrayList<>();

        StringBuffer sb = new StringBuffer(input);
        sb.deleteCharAt(index);
        String removedBegin = sb.toString();

        for (int i = 0; i < wordList.length; i++) {
            StringBuffer sb1 = new StringBuffer(wordList[i]);
            sb1.deleteCharAt(index);
            if (sb1.toString().equals(removedBegin)) {
                result.add(i);
            }
        }

        return result;
    }
}