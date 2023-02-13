import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map<String, Integer> map = new HashMap<>();

        //(장르, 재생횟수)
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        Order<String> order = new Order();
        List<String> genreOrder = order.orderMap(map);

        Map<String, Map<Integer, Integer>> lhm = new LinkedHashMap<>();

        //장르 순서 넣기
        for (String str : genreOrder) {
            lhm.put(str, new LinkedHashMap<>());
        }

        //재생 횟수 넣기
        for (int i = 0; i < genres.length; i++) {
            lhm.get(genres[i]).put(i, plays[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        //장르 내 정렬하기
        for (String str : genreOrder) {
            Order orderInteger = new Order();
            List<Integer> orderedList = orderInteger.orderMap(lhm.get(str));
            result.add(orderedList);
        }

        List<Integer> last = new ArrayList<>();

        for (List<Integer> list : result) {
            int iter = 0;
            if (list.size() < 2) {
                iter = list.size();
            } else if (list.size() >= 2) {
                iter = 2;
            }
            for (int i = 0; i < iter; i++) {
                last.add(list.get(i));
            }
        }

        int[] answer = new int[last.size()];

        for (int i = 0; i < last.size(); i++) {
            answer[i] = last.get(i);
        }

        return answer;
    }
}

class Order<T> {
    public List<T> orderMap(Map<T, Integer> map) {
        List<T> list = new ArrayList(map.keySet());
        
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        
        return list;
    }
}