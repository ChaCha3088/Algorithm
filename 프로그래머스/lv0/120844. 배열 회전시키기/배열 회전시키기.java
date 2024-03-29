class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if (direction.equals("right")) {
            for (int i = 0; i < numbers.length; i++) {
                answer[i] = numbers[(i + numbers.length - 1) % numbers.length];
            }
            
        } else if (direction.equals("left")) {
            for (int i = 0; i < numbers.length; i++) {
                answer[i] = numbers[(i + 1) % numbers.length];
            }
            
        }
        
        return answer;
    }
}