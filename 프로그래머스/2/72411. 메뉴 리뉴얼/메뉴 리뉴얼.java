import java.util.*;
class Solution {
    Map<Integer,Map<String, Integer>> map; // 길이, 메뉴조합, 반복횟수
    Set<Integer> set; // course
    int courseMax;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        courseMax = course[course.length - 1];
        for(int n : course) map.put(n, new HashMap<>());
        for(int n : course) set.add(n);

        for(String order : orders){ // map 에 입력
            order = sortString(order);
            dfs(order, new StringBuilder(), 0, new boolean[order.length()]);
        }

        for(int n : course){
            int max = 0; 
            Map<String, Integer> temp = map.get(n);
            for(String key : temp.keySet()) // 길이별로 max 구함
                max = Math.max(max, temp.get(key));

            if(max < 2) continue; // 2 미만 패스
            for(String key : temp.keySet())
                if(temp.get(key) == max) ans.add(key);
        }

        Collections.sort(ans); 
        return ans.toArray(new String[0]);
    }

    public void dfs(String s, StringBuilder sb, int t, boolean[] check){
        int len = sb.length();
        if(set.contains(len)){
            String comb = sb.toString();
            int cnt = map.get(len).getOrDefault(comb, 0) + 1;

            map.get(len).put(comb, cnt);
            if(sb.length() == courseMax) return;
        }

        for(int i = t; i < s.length(); i ++){
            if(check[i]) continue;
            sb.append(s.charAt(i));
            check[i] = true;
            dfs(s, sb, i + 1, check);
            check[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String sortString(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}