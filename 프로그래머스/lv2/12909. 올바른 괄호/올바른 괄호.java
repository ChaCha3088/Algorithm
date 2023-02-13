import java.util.*;

class Solution {
    boolean solution(String s) {
        int status = 0;
        
        char[] splitted = s.toCharArray();
        
        if (splitted[0] == ')') {
            return false;
        }
        if (splitted[splitted.length - 1] == '(') {
            return false;
        }

        for (int i = 0; i < splitted.length; i++) {
            if (status <= -1) {
                return false;
            }
            
            if (splitted[i] == '(') {
                status += 1;
            } else if (splitted[i] == ')') {
                status -= 1;
            } else {
                return false;
            }
        }

        if (status == 0) {
            return true;
        } else {
            return false;
        }

    }
}