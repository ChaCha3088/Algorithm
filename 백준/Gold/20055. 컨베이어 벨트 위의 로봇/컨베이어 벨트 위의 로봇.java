import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Belt {
        private int durability;
        private Robot robot;

        public Belt(int durability) {
            this.durability = durability;
            this.robot = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("durability = " + this.durability + ", ");
            sb.append("robotNumber = ");

            if (robot == null) {
                sb.append("없음");
            }
            else {
                sb.append(robot.robotNumber);
            }

            return sb.toString();
        }
    }

    static class Robot {
        private int robotNumber;

        public Robot(int robotNumber) {
            this.robotNumber = robotNumber;
        }
    }

    private static int N, K;
    private static int howMany = 0;
    private static int step = 1;
    private static int putRobotNumber = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<Belt> upperConveyor = new ArrayDeque();
        Deque<Belt> lowerConveyor = new ArrayDeque();

        st = new StringTokenizer(br.readLine());

        // 위 컨베이어 태우기
        for (int n = 1; n <= N; n++) {
            int durability = Integer.parseInt(st.nextToken());
            upperConveyor.offerLast(new Belt(durability));
        }
        for (int n = 1; n <= N; n++) {
            int durability = Integer.parseInt(st.nextToken());
            lowerConveyor.offerLast(new Belt(durability));
        }

        while (true) {
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // 1. 벨트 회전

            // 컨베이어 벨트 로봇 내리기
            Belt lastBeltOfUpperConveyor = upperConveyor.pollLast();

            // 내릴거 내리기
            Belt toPullOut = upperConveyor.peekLast();
            if (toPullOut.robot != null) {
                toPullOut.robot = null;
            }

            // 아래 컨베이어로 옮기기
            lowerConveyor.offerFirst(lastBeltOfUpperConveyor);

            // 아래 컨베이어 마지막거 위로 올리기
            Belt lastBeltOfLowerConveyor = lowerConveyor.pollLast();
            upperConveyor.offerFirst(lastBeltOfLowerConveyor);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // 가장 먼저 올라간 로봇의 숫자를 찾는다.

            // 하나의 리스트로 합치기
            List<Belt> list1 = upperConveyor.stream().collect(Collectors.toList());
            List<Belt> list2 = lowerConveyor.stream().collect(Collectors.toList());
            List<Belt> list = new ArrayList();
            list.addAll(list1);
            list.addAll(list2);


            // 다 로봇이 다 배달됐으면
            // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.

            // 가장 먼저 올라간 로봇의 위치를 찾는다.
            int lowestRobotBeltIndex = findLowestRobotBeltIndex(list);


            // 로봇을 움직인다.
            if (lowestRobotBeltIndex != -1) {
                boolean result = moveRobot(lowestRobotBeltIndex, list);

                if (result) {
                    System.out.println(step);
                    return;
                }
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Belt firstBeltOfUpperConveyor = upperConveyor.peekFirst();

            // 벨트가 비어있고, 내구도가 1 이상이면 로봇을 올린다.
            if (firstBeltOfUpperConveyor.robot == null && firstBeltOfUpperConveyor.durability >= 1) {
                firstBeltOfUpperConveyor.durability -= 1;
                if (firstBeltOfUpperConveyor.durability == 0) {
                    howMany += 1;

                    if (howMany >= K) {
                        System.out.println(step);
                        return;
                    }
                }

                firstBeltOfUpperConveyor.robot = new Robot(putRobotNumber++);
            }

            // 다음 스텝
            step += 1;
        }
    }

    private static boolean moveRobot(int startRobotIndex, List<Belt> listOfBelt) {
        int index = startRobotIndex;
        int count = 0;

        Robot temp = null;

        while (true) {
            if (count >= 2 * N - 1) {
                break;
            }

            Belt targetBelt = listOfBelt.get(index);

            // 벨트에 로봇이 있고
            if (targetBelt.robot != null) {
                int nextIndex = (index + 1) % (2 * N);

                Belt nextBelt = listOfBelt.get(nextIndex);
                // 갈 곳에 내구도가 1 이상일 때, 다음 벨트에 로봇이 없으면 가능
                if (nextBelt.durability >= 1 && nextBelt.robot == null) {
                    // N - 2 이면
                    if (index == N - 2) {
                        // 다음으로 넘기지 않고 바로 삭제
                        nextBelt.durability -= 1;

                        if (nextBelt.durability == 0) {
                            howMany += 1;

                            // K 이상 되면
                            if (howMany >= K) {
                                // 끝
                                return true;
                            }
                        }

                        targetBelt.robot = null;
                    } else {
                        // 임시 백업
                        temp = nextBelt.robot;

                        // 다음거에 정보 넘기고
                        nextBelt.robot = targetBelt.robot;

                        // 다음거 내구도 까고
                        if (nextBelt.durability >= 1) {
                            nextBelt.durability -= 1;
                            if (nextBelt.durability == 0) {
                                howMany += 1;

                                // K 이상 되면
                                if (howMany >= K) {
                                    // 끝
                                    return true;
                                }
                            }
                        }

                        // 원래거 삭제하고
                        targetBelt.robot = null;
                    }
                }

            }

            if (count <= 2 * N - 1) {
                if (index == 0) {
                    index = 2 * N - 1;
                }
                else {
                    index -= 1;
                }
            }

            count += 1;
        }

        listOfBelt.get((index + 1) % (2 * N)).robot = temp;

        return false;
    }

    private static int findLowestRobotBeltIndex(List<Belt> listOfBelts) {
        for (int i = listOfBelts.size() - 1; i >= 0; i--) {
            if (listOfBelts.get(i).robot != null) {
                return i;
            }
        }

        return -1;
    }
}