import java.util.*;

class Solution {
    private static int answer = 0;
    private static List<int[][]> list = new ArrayList<>();
    
    public int solution(String[][] book_time) {
        // 끝나는 시간으로 정렬
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                return o1[0].compareTo(o2[0]);
            }
            return o1[1].compareTo(o2[1]);
        });

        for (int i = 0; i < book_time.length; i++) {
            // list의 크기가 0이면 그냥 넣는다.
            if (list.isEmpty()) {
                int[][] newOne = new int[25][60];

                String[] target = book_time[i];
                String[] split = target[0].split(":");
                int startHour = Integer.parseInt(split[0]);
                int startMin = Integer.parseInt(split[1]);

                split = target[1].split(":");
                int endHour = Integer.parseInt(split[0]);
                int endMin = Integer.parseInt(split[1]) + 10;

                if (endMin >= 60) {
                    endMin -= 60;
                    endHour += 1;
                }

                if (endHour >= 24) {
                    endHour = 23;
                    endMin = 59;
                }

                for (int m = startMin; m < 60; m++) {
                    newOne[startHour][m] = 1;
                }

                for (int m = 0; m < endMin; m++) {
                    newOne[endHour][m] = 1;
                }

                for (int h = startHour + 1; h <= endHour - 1; h++) {
                    for (int m = 0; m < 60; m++) {
                        newOne[h][m] = 1;
                    }
                }

                // 마지막 시간 기록
                newOne[0][0] = endHour * 100 + endMin;

                answer += 1;

                list.add(newOne);
            }
            // 아니면 순회하면서 들어갈 수 있는 곳을 찾는다.
            else {
                String[] target = book_time[i];
                String[] split = target[0].split(":");
                int startHour = Integer.parseInt(split[0]);
                int startMin = Integer.parseInt(split[1]);

                split = target[1].split(":");
                int endHour = Integer.parseInt(split[0]);
                int endMin = Integer.parseInt(split[1]) + 10;

                if (endMin >= 60) {
                    endMin -= 60;
                    endHour += 1;
                }

                if (endHour >= 24) {
                    endHour = 23;
                    endMin = 59;
                }

                int startTime = startHour * 100 + startMin;

                boolean isEnd = false;

                for (int[][] e : list) {
                    // 끼워넣을 수 있으면
                    if (e[0][0] <= startTime) {
                        for (int m = startMin; m < 60; m++) {
                            e[startHour][m] = 1;
                        }

                        for (int m = 0; m < endMin; m++) {
                            e[endHour][m] = 1;
                        }

                        for (int h = startHour + 1; h <= endHour - 1; h++) {
                            for (int m = 0; m < 60; m++) {
                                e[h][m] = 1;
                            }
                        }

                        // 마지막 시간 기록
                        e[0][0] = endHour * 100 + endMin;

                        answer += 1;

                        isEnd = true;

                        break;
                    }
                }

                if (!isEnd) {
                    int[][] newOne = new int[25][60];

                    for (int m = startMin; m < 60; m++) {
                        newOne[startHour][m] = 1;
                    }

                    for (int m = 0; m < endMin; m++) {
                        newOne[endHour][m] = 1;
                    }

                    for (int h = startHour + 1; h <= endHour - 1; h++) {
                        for (int m = 0; m < 60; m++) {
                            newOne[h][m] = 1;
                        }
                    }

                    // 마지막 시간 기록
                    newOne[0][0] = endHour * 100 + endMin;

                    answer += 1;

                    list.add(newOne);
                }
            }

            // 마지막 시간으로 정렬
            list.sort(Comparator.comparingInt(o -> -1 * o[0][0]));
        }
        
        return list.size();
    }

}