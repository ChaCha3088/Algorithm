import java.util.*;

class Solution {
    static class Skill {
        private Integer previous;
        private Integer next;
        private char name;
        
        public Skill(char name, Character previous, Character next) {
            this.name = name;
            this.previous = previous == null ? null : previous - '0';
            this.next = next == null ? null : next - '0';
        }
    }
    
    private List<Skill> list;
    private int answer;
    
    public int solution(String skill, String[] skill_trees) {
        list = new ArrayList<Skill>(skill.length());
        
        for (int i = 0; i < skill.length(); i++) {
            Skill temp;
            
            if (i == 0) {
                temp = new Skill(skill.charAt(i), null, skill.charAt(i + 1));
            }
            else if (i == skill.length() - 1) {
                temp = new Skill(skill.charAt(i), skill.charAt(i - 1), null);
            }
            else {
                temp = new Skill(skill.charAt(i), skill.charAt(i - 1), skill.charAt(i + 1));
            }
            
            list.add(temp);
        }
        
        // 스킬 트리들을 한 글자씩 HashMap에 넣는다.
        for (int i = 0; i < skill_trees.length; i++) {
            char[] arr = skill_tree[i].toCharArray();
            
            for (int j = 0; j < arr.length; j++) {
                
            }
        }
        
        // 중간에 하나라도 실패하면 실패
        
        return -1;
    }
}