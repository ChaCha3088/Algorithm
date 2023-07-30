class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        String[] babblingCopied = babbling.clone();
        
        for (int i = 0; i < babbling.length; i++) {
            System.out.println("Target is");
            System.out.println(babbling[i]);
            
            for (int j = 0; j < words.length; j++) {
                if (babblingCopied[i].contains(words[j])) {
                    System.out.println("true");
                    babblingCopied[i] = babblingCopied[i].replace(words[j], "0");
                    System.out.println("Remain words are");
                    System.out.println(babblingCopied[i]);
                }
            }
            try {
                Integer.parseInt(babblingCopied[i]);
                System.out.println("Success");
                count++;
                System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            } catch (NumberFormatException e) {
                
            }
        }
        return count;
    }
}