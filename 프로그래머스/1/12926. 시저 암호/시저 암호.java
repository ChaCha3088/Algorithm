class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        int counts = 'z' - 'a' + 1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            else if ('a' <= arr[i] && arr[i] <= 'z') {
                int temp = arr[i] + n;
                
                arr[i] = (char) temp;
                
                if (temp > 'z') {
                    arr[i] = (char) (temp - counts);
                }
            }
            else {
                int temp = arr[i] + n;
                
                arr[i] = (char) temp;
                
                if (temp > 'Z') {
                    arr[i] = (char) (temp - counts);
                }
            }
        }
        
        return String.valueOf(arr);
    }
}